package com.iintelliguru.designpattern.pipelinedesignpattern.pipeline;
@FunctionalInterface
public interface MessageHandler<I, O>{
    O process(I input);
}
