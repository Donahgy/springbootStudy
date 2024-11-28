# Springboot中事件的匹配原理

springboot的事件匹配机制是通过事件发生的源对象以及事件类型共同去匹配相关监听器的。

以Springboot容器启动为例：

​		1、遍历listener的集合，调用starting()方法发布springboot容器正在启动的事件。

```java
   void starting() {
		for (SpringApplicationRunListener listener : this.listeners) {
			listener.starting();
		}
	}
```

​		 2、使用早期事件多播器，发布一个ApplicationStartingEvent事件。

```java
    @Override
	public void starting() {
		this.initialMulticaster.multicastEvent(new ApplicationStartingEvent(this.application, this.args));
	}
```

​		3、发布事件

​		(1)、首先调用resolveDefaultEventType(event)方法，该方法返回的是一个ResolvableType，主要用于将原始对象封装成一个ResolvableType即可以分解的对象，其目的是为了解析事件的泛型信息。

​		(2)、然后再调用 getApplicationListeners(event, type)方法，获取到支持当前事件的所有监听器实例，然后一一调用它们的onApplicationEvent(event)方法，完成事件的监听动作，从而对相关的事件做出响应。

```java
	@Override
	public void multicastEvent(final ApplicationEvent event, @Nullable ResolvableType eventType) {
		ResolvableType type = (eventType != null ? eventType : resolveDefaultEventType(event));
		Executor executor = getTaskExecutor();
		for (ApplicationListener<?> listener : getApplicationListeners(event, type)) {
			if (executor != null) {
				executor.execute(() -> invokeListener(listener, event));
			}
			else {
				invokeListener(listener, event);
			}
		}
	}
```

​	4、在缓存中获取事件对应的监听器实例

​	(1)、解析到触发事件的原始对象，获取该对象的Class信息。

​	(2)、创建一个ListenerCacheKey对象，该对象在后面会作为缓存的key，查询相关缓存信息，构造方法的两个参数分别是事件类型和触发事件的源对象。因此可以推断出获取监听器是通过事件类型和触发事件的源对象共同匹配的。

​	(3)、创建一个CachedListenerRetriever对象，该对象中主要有两个属性，一个是applicationListeners，一个是applicationListenerBeans。主要用于存储当前事件所匹配到的所有监听器信息。

​	(4)、根据(2)中的缓存key值，获取CachedListenerRetriever对象。缓存retrieverCache的作用是，是一个用于存储已经匹配到监听器的事件和监听器的对象集合。

​	(5)、判断缓存中是否存在相关CachedListenerRetriever对象，如果不存在，创建一个新的CachedListenerRetriever对象，并将所创建的对象作为value，将(2)中创建的ListenerCacheKey对象作为key，将其put到缓存中。

​	(6)、如果缓存中查询到相关的CachedListenerRetriever对象，则直接获取到缓存中存储的监听器对象信息，并将其返回。

​	(7)、当缓存中不存在对应key的值时，调用retrieveApplicationListeners(eventType, sourceType, newRetriever)方法，该方法需要三个参数，分别是事件类型、触发事件的源对象、以及(3)中创建的CachedListenerRetriever对象。

```java
protected Collection<ApplicationListener<?>> getApplicationListeners(
			ApplicationEvent event, ResolvableType eventType) {
		Object source = event.getSource();
		Class<?> sourceType = (source != null ? source.getClass() : null);
		ListenerCacheKey cacheKey = new ListenerCacheKey(eventType, sourceType);
		CachedListenerRetriever newRetriever = null;
		CachedListenerRetriever existingRetriever = this.retrieverCache.get(cacheKey);
		if (existingRetriever == null) {
			if (this.beanClassLoader == null ||
					(ClassUtils.isCacheSafe(event.getClass(), this.beanClassLoader) &&
							(sourceType == null || ClassUtils.isCacheSafe(sourceType, this.beanClassLoader)))) {
				newRetriever = new CachedListenerRetriever();
				existingRetriever = this.retrieverCache.putIfAbsent(cacheKey, newRetriever);
				if (existingRetriever != null) {
					newRetriever = null;  
				}
			}
		}
		if (existingRetriever != null) {
			Collection<ApplicationListener<?>> result = existingRetriever.getApplicationListeners();
			if (result != null) {
				return result;
			}
		}
		return retrieveApplicationListeners(eventType, sourceType, newRetriever);
	}
```

5、该方法才是最终匹配事件及监听器的方法，然后将匹配结果设置到retriever对象中，因此当下一次当事件和触发事件的源对象相同时可以直接从缓存中根据缓存key值直接获取相关的监听器集合。

(1)、创建一个用于存储所有匹配到该事件的所有监听器集合和一个用于存储经过过滤后并且匹配到该事件的监听器集合。(说明：为什么需要过滤，因为缓存中存储的只是单例的监听器集合，对于多例对象，即每一次发布事件后都需要重新创建监听器对象的监听器则存储到filteredListeners中。)

(2)、创建一个用于存储过滤后监听器的bean名称集合。

(3)、从默认的defaultRetriever对象中获取到所有默认的监听器对象信息集合以及相关过滤的bean名称集合。默认的defaultRetriever是在创建EventPublishingRunListener对象时，根据构造函数创建的。

(4)、遍历存储所有监听器对象的集合判断当前监听器是否支持相关的事件，如果支持并且相关的retriever不为空，则将对应的监听器分别存入filteredListeners和allListeners集合中，allListeners是该方法返回值，最终会返回支持当前事件的所有监听器集合。

(5)、判断listenerBeans是否不为空，如果不为空则说明有需要被创建的监听器对象实例，因此遍历listenerBeans集合，判断当前监听器是否支持该事件，如果支持同时allListeners又不包含该监听器实例，则判断当前实例是否为单例对象，如果为单例对象则将其添加到filteredListeners中，否则添加到filteredListenerBeans集合中，说明下次有相同事件被触发后，需要再次重新创建该监听器实例信息。然后将该监听器添加到allListeners等待被返回。如果不支持当前事件，则需要从filteredListeners和allListeners被移除掉当前监听器实例。

(6)、判断retriever是否为空，因为retriever是否为空关系到当前事件匹配到的这些监听器是否应该被设置到4(4)中所提到的缓存对象中。然后判断filteredListenerBeans是否为空，当它为空时则说明当前所有匹配到该事件的监听器对象均为单例对象，不需要额外创建，因此直接设置在retriever对象的applicationListeners中就可以了，否则说明匹配到该事件的监听器对象有一部分不是单例对象，下次触发该事件后需要区分监听器信息，对于retriever.applicationListenerBeans需要重新创建监听器实例，而对于retriever.applicationListeners则不需要重新创建。

(7)、最终返回匹配到该事件的所有监听器实例集合，以供执行相关的监听动作。



```java
private Collection<ApplicationListener<?>> retrieveApplicationListeners(
			ResolvableType eventType, @Nullable Class<?> sourceType, @Nullable CachedListenerRetriever retriever) {

		List<ApplicationListener<?>> allListeners = new ArrayList<>();
		Set<ApplicationListener<?>> filteredListeners = (retriever != null ? new LinkedHashSet<>() : null);
		Set<String> filteredListenerBeans = (retriever != null ? new LinkedHashSet<>() : null);

		Set<ApplicationListener<?>> listeners;
		Set<String> listenerBeans;
		synchronized (this.defaultRetriever) {
			listeners = new LinkedHashSet<>(this.defaultRetriever.applicationListeners);
			listenerBeans = new LinkedHashSet<>(this.defaultRetriever.applicationListenerBeans);
		}

		for (ApplicationListener<?> listener : listeners) {
			if (supportsEvent(listener, eventType, sourceType)) {
				if (retriever != null) {
					filteredListeners.add(listener);
				}
				allListeners.add(listener);
			}
		}

		if (!listenerBeans.isEmpty()) {
			ConfigurableBeanFactory beanFactory = getBeanFactory();
			for (String listenerBeanName : listenerBeans) {
				try {
					if (supportsEvent(beanFactory, listenerBeanName, eventType)) {
						ApplicationListener<?> listener =
								beanFactory.getBean(listenerBeanName, ApplicationListener.class);
						if (!allListeners.contains(listener) && supportsEvent(listener, eventType, sourceType)) {
							if (retriever != null) {
								if (beanFactory.isSingleton(listenerBeanName)) {
									filteredListeners.add(listener);
								}
								else {
									filteredListenerBeans.add(listenerBeanName);
								}
							}
							allListeners.add(listener);
						}
					}
					else {
						Object listener = beanFactory.getSingleton(listenerBeanName);
						if (retriever != null) {
							filteredListeners.remove(listener);
						}
						allListeners.remove(listener);
					}
				}
				catch (NoSuchBeanDefinitionException ex) {
					
				}
			}
		}

		AnnotationAwareOrderComparator.sort(allListeners);
		if (retriever != null) {
			if (filteredListenerBeans.isEmpty()) {
				retriever.applicationListeners = new LinkedHashSet<>(allListeners);
				retriever.applicationListenerBeans = filteredListenerBeans;
			}
			else {
				retriever.applicationListeners = filteredListeners;
				retriever.applicationListenerBeans = filteredListenerBeans;
			}
		}
		return allListeners;
	}
```

