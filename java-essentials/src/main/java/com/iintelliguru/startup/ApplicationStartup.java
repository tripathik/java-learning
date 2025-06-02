package com.iintelliguru.startup;

import com.iintelliguru.designpattern.pipelinedesignpattern.service.MessageService;
import com.iintelliguru.designpattern.pipelinedesignpattern.service.exchange.MessageRequestDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements CommandLineRunner {
    private MessageService messageService;
    @Override
    public void run(String... args) throws Exception {
        MessageRequestDTO messageRequestDTO = MessageRequestDTO.builder().build();
        messageService.processMessage(messageRequestDTO);
    }
}
