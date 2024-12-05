# 关于supportsEvent方法的分析

在supportsEvent方法中则描述了监听器是如何匹配到具体事件的。

## 一、关于ResolvableType的解析

ResolvableType是spring中用于解析类泛型信息的，spring会将需要解析泛型信息类的对象封装成一个

ResolvableType对象，从而获取它的泛型信息。

传递给它一个class对象，其中this.resolved和this.type都是传递进来的class信息。

```java
private ResolvableType(@Nullable Class<?> clazz) {
		this.resolved = (clazz != null ? clazz : Object.class);
		this.type = this.resolved;
		this.typeProvider = null;
		this.variableResolver = null;
		this.componentType = null;
		this.hash = null;
	}
```

## 二、supportsEvent方法的解析

1、首先会判断当前监听器是否是GenericApplicationListener类型，如果不是则要对当前监听器进行包装，即创建一个GenericApplicationListenerAdapter对象，参数为当前监听器的实例。

```java
protected boolean supportsEvent(
			ApplicationListener<?> listener, ResolvableType eventType, @Nullable Class<?> sourceType) {
		GenericApplicationListener smartListener = (listener instanceof GenericApplicationListener ?
				(GenericApplicationListener) listener : new GenericApplicationListenerAdapter(listener));
		return (smartListener.supportsEventType(eventType) && smartListener.supportsSourceType(sourceType));
	}
```

2、 new GenericApplicationListenerAdapter(listener)

this.delegate的对象即为当前监听器的实例。

紧接着调用resolveDeclaredEventType(this.delegate)方法，将当前监听器进一步封装为ResolvableType对象

```java
	public GenericApplicationListenerAdapter(ApplicationListener<?> delegate) {
		Assert.notNull(delegate, "Delegate listener must not be null");
		this.delegate = (ApplicationListener<ApplicationEvent>) delegate;
		this.declaredEventType = resolveDeclaredEventType(this.delegate);
	}
```

2.1、在resolveDeclaredEventType方法中

eventTypeCache缓存存储的是监听器 -> 事件类型，是一个map结构。

2.1.1、首先从eventTypeCache缓存中根据监听器获取对应的事件类型，如果获取到了则直接返回。

2.1.2、如果没有获取到则调用ResolvableType.forClass(listenerType)方法，先将监听器封装成一个ResolvableType对象，然后调用as(ApplicationListener.class)方法，获取到ApplicationListener.class类型的接口信息，然后再调用getGeneric()方法，获取接口中定义的泛型信息。

```java
static ResolvableType resolveDeclaredEventType(Class<?> listenerType) {
   ResolvableType eventType = eventTypeCache.get(listenerType);
   if (eventType == null) {
      eventType = ResolvableType.forClass(listenerType).as(ApplicationListener.class).getGeneric();
      eventTypeCache.put(listenerType, eventType);
   }
   return (eventType != ResolvableType.NONE ? eventType : null);
}
```

2.1.3、关于as方法的解析如下

判断当前对象是否为空，如果不为空，则获取到resolved对象，resolved对象就是一中提到的class信息。

判断resolved是否为空，如果为空或者等于传递进来的type，则直接返回。为空时意味着没必要再进行进一步的解析，当resolved等于type时，则说明当前对象已经就是我们需要的对象了，没必要再进行解析。

然后通过getInterfaces()方法，获取到class对象的所有接口信息，遍历，当遍历到接口类型和type类型相等时，则直接返回。

```java
public ResolvableType as(Class<?> type) {
   if (this == NONE) {
      return NONE;
   }
   Class<?> resolved = resolve();
   if (resolved == null || resolved == type) {
      return this;
   }
   for (ResolvableType interfaceType : getInterfaces()) {
      ResolvableType interfaceAsType = interfaceType.as(type);
      if (interfaceAsType != NONE) {
         return interfaceAsType;
      }
   }
   return getSuperType().as(type);
}
```

2.2、最后将对应的监听器和事件类型存入缓存，然后返回当前的事件类型。将返回的对象赋值给this.declaredEventType对象。

## 三、supportsEventType(ResolvableType eventType)方法解析

以GenericApplicationListenerAdapter类中的方法为例

this.delegate就是当前的监听器信息，判断当前监听器是否时SmartApplicationListener类型，如果不是直接判断当前监听器所支持的事件类型是否可以被分配成传递进来的eventType类型。

如果是，则解析到监听器类型中的事件类型调用具体监听器中的supportsEventType方法，判断当前事件类型是否是被监听器支持的类型。

最后返回结果。

```java
public boolean supportsEventType(ResolvableType eventType) {
   if (this.delegate instanceof SmartApplicationListener) {
      Class<? extends ApplicationEvent> eventClass = (Class<? extends ApplicationEvent>) eventType.resolve();
      return (eventClass != null && ((SmartApplicationListener) this.delegate).supportsEventType(eventClass));
   }
   else {
      return (this.declaredEventType == null || this.declaredEventType.isAssignableFrom(eventType));
   }
}
```

## 四、supportsSourceType(sourceType)方法

该方法默认返回true，如果需要自定义匹配，则需要自己实现GenericApplicationListener接口，然后进行自定义事件源的匹配。

```
default boolean supportsSourceType(@Nullable Class<?> sourceType) {
   return true;
}
```