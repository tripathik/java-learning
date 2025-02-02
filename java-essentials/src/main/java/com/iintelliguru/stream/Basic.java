package com.iintelliguru.stream;

import org.apache.commons.lang3.StringUtils;
import org.thymeleaf.util.ObjectUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Basic {
    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("key1", ",abcd@test.com,abc@test.com,");
        String[] onlyEmailList = StringUtils.isNoneEmpty(stringMap.get("key1")) ?
                Arrays.stream(stringMap.get("key1")
                        .split(","))
                        .filter(StringUtils::isNoneEmpty).toArray(String[]::new) : new String[0];
        for(String email: onlyEmailList){
            System.out.println(email);
        }

    }
}
