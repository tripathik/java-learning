package com.iintelliguru.core.annotations.dto;

import com.iintelliguru.core.annotations.custom.AppConfiguration;
import com.iintelliguru.core.annotations.custom.EnvironmentConfiguration;
import com.iintelliguru.core.annotations.custom.SecretsConfiguration;
import com.iintelliguru.core.annotations.custom.service.AnnotationsService;
import lombok.Data;
@Data
public class CredentialsDTO {
    @EnvironmentConfiguration(key = "apiKey")
    private String apiKey;
    @SecretsConfiguration(key = "secretKey")
    private String secretKey;
    @AppConfiguration(key = "appId")
    private String appId;

    public static void assignFieldValue(){
        AnnotationsService.assignConfigurationValue(CredentialsDTO.class);
    }

}
