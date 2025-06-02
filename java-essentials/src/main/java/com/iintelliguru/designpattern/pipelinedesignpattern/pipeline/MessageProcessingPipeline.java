package com.iintelliguru.designpattern.pipelinedesignpattern.pipeline;

public class MessageProcessingPipeline<I, O> {
    private final MessageHandler<I, O> currentMessageHandler;

    public MessageProcessingPipeline(MessageHandler<I, O> messageHandler) {
        this.currentMessageHandler = messageHandler;
    }

    public <K> MessageProcessingPipeline<I,K> addHandler(MessageHandler<O, K> newMessageHandler){
        return new MessageProcessingPipeline<>(input -> newMessageHandler.process(currentMessageHandler.process(input)));
    }

    public O execute(I input){
        return currentMessageHandler.process(input);
    }
}
