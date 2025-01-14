package com.iintelliguru.core.annotations.custom.service;

import com.iintelliguru.core.annotations.custom.AppConfiguration;
import com.iintelliguru.core.annotations.custom.EnvironmentConfiguration;
import com.iintelliguru.core.annotations.custom.SecretsConfiguration;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
@Slf4j
public class AnnotationsService {
    public static void assignConfigurationValue(Object classInstance){
        try {
            Field[] fields = classInstance.getClass().getDeclaredFields();
            for(Field field : fields){
                if(field.isAnnotationPresent(EnvironmentConfiguration.class)){
                    assignValue(classInstance, field, System.getenv("apiKey"));
                }
                if(field.isAnnotationPresent(AppConfiguration.class)){
                    assignValue(classInstance, field, "api-id00123");
                }
                if(field.isAnnotationPresent(SecretsConfiguration.class)){
                    assignValue(classInstance, field, "secret-id-12345");
                }
            }
        } catch (IllegalAccessException e) {
            log.error("Some error occurred");
        }
    }

    private static void assignValue(Object classInstance, Field field, String value) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(classInstance,value);
    }
}
