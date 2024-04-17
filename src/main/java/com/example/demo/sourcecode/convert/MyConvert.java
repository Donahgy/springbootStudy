package com.example.demo.sourcecode.convert;

import com.example.demo.sourcecode.convert.bean.Person;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 自定义实现ConversionService接口，实现自己的类型转换器
 */
@Component
public class MyConvert implements ConversionService {

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        assert sourceType != null;
        System.out.println(sourceType.getName());
        System.out.println(sourceType.getClass().getName());
        return true;
    }

    @Override
    public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return false;
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        TypeDescriptor sourceType = TypeDescriptor.forObject(source);
        TypeDescriptor typeDescriptor = TypeDescriptor.valueOf(targetType);
        Object object = convert(source, sourceType, typeDescriptor);
        return (T) object;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Map<String, String> sourceMap = (Map<String, String>) source;
        try {
            Person person = (Person) targetType.getObjectType().newInstance();
            person.setName(sourceMap.get("name"));
            person.setAge(Integer.parseInt(sourceMap.get("age")));
            return person;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
