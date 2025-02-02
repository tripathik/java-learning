package com.iintelliguru.topcoding;

import com.iintelliguru.topcoding.dto.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(101, "Keyboard", 1265.00),
                new Product(102, "Mouse", 1009.00),
                new Product(103, "Monitor", 12345.00),
                new Product(103, "Mobile", 12345.00)

        );

        Map<Integer, Product> productMap = productList.stream()
                .collect(Collectors.toMap(Product::getId,
                        Function.identity(),
                        (existing, replacement)->existing//Merge function
                        // by the help of this merge function, either we can keep the existing value or replacement value
                ));
        for(int i = 101; i<=103; i++){
            System.out.println(productMap.get(i).toString());
        }

    }


}
