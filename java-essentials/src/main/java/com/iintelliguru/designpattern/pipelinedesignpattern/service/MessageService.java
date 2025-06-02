package com.iintelliguru.designpattern.pipelinedesignpattern.service;

import com.iintelliguru.designpattern.pipelinedesignpattern.handler.MessageProcessing;
import com.iintelliguru.designpattern.pipelinedesignpattern.handler.MessagePublished;
import com.iintelliguru.designpattern.pipelinedesignpattern.handler.MessageReceived;
import com.iintelliguru.designpattern.pipelinedesignpattern.pipeline.MessageProcessingPipeline;
import com.iintelliguru.designpattern.pipelinedesignpattern.service.exchange.MessageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {
    private final MessageReceived messageReceived;
    private final MessageProcessing messageProcessing;
    private final MessagePublished messagePublished;

    public int processMessage(MessageRequestDTO messageRequestDTO){
        MessageProcessingPipeline<MessageRequestDTO, MessageRequestDTO> pipeline = new MessageProcessingPipeline<>(messageReceived)
                .addHandler(messageProcessing)
                .addHandler(messagePublished);

        pipeline.execute(messageRequestDTO);

        log.info("Request Completed Successfully!");
        return 0;
    }
}
