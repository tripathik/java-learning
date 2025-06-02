package com.iintelliguru;

import com.iintelliguru.designpattern.pipelinedesignpattern.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JavaLearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaLearningApplication.class, args);
        log.info("Application Started..");

    }
}
