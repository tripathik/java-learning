package com.iintelliguru.core.annotations;

import com.iintelliguru.core.annotations.dto.CredentialsDTO;
import com.iintelliguru.core.annotations.dto.RequestDTO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AnnotationsExample {
    private CredentialsDTO credentialsDTO;

    public void handleAnnotations(){
        CredentialsDTO.assignFieldValue();

        CredentialsDTO credentials = new CredentialsDTO();
        credentials.setApiKey(credentialsDTO.getApiKey());
        credentials.setSecretKey(credentialsDTO.getSecretKey());
        credentials.setAppId(credentialsDTO.getAppId());

        RequestDTO requestDTO = RequestDTO.builder()
                .credentials(credentials)
                .requestId("req-idsdbwsdg12345")
                .build();

        log.info(String.format("RequestDTO built successfully: RequestDTO: %s",requestDTO));


    }

    public static void main(String[] args) {
        AnnotationsExample annotationsExample = new AnnotationsExample();
        annotationsExample.handleAnnotations();
    }

}
