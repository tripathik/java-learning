package com.iintelliguru.designpattern.pipelinedesignpattern.handler;

import com.iintelliguru.designpattern.pipelinedesignpattern.pipeline.MessageHandler;
import com.iintelliguru.designpattern.pipelinedesignpattern.service.exchange.MessageRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class MessageReceived implements MessageHandler<MessageRequestDTO, MessageRequestDTO> {
    @Override
    public MessageRequestDTO process(MessageRequestDTO messageRequestDTO) {
        MessageRequestDTO messageRequestDTOResult = null;
        if(messageRequestDTO.getMessageId() == null){
            List<String> steps = new ArrayList<>();
            steps.add("Request Received");
            messageRequestDTOResult = MessageRequestDTO.builder()
                    .messageId(UUID.randomUUID().toString())
                    .steps(steps)
                    .build();
        }
        log.info("MessageRequestDto: {}", messageRequestDTOResult);
        return messageRequestDTOResult;
    }
}
