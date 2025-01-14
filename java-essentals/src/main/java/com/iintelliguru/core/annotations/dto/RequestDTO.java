package com.iintelliguru.core.annotations.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDTO {
    private String requestId;
    private CredentialsDTO credentials;
}
