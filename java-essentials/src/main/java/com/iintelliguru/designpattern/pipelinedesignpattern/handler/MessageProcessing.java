package com.iintelliguru.designpattern.pipelinedesignpattern.handler;

import com.iintelliguru.designpattern.pipelinedesignpattern.pipeline.MessageHandler;
import com.iintelliguru.designpattern.pipelinedesignpattern.service.exchange.MessageRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessing implements MessageHandler<MessageRequestDTO, MessageRequestDTO> {
    @Override
    public MessageRequestDTO process(MessageRequestDTO messageRequestDTO) {
        return messageRequestDTO;
    }
}
