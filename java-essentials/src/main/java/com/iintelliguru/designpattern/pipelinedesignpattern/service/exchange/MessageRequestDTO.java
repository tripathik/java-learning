package com.iintelliguru.designpattern.pipelinedesignpattern.service.exchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class MessageRequestDTO {
    private String messageId;
    private List<String> steps;
}
