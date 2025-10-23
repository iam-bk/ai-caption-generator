package com.zepic.captiongenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.sagemakerruntime.SageMakerRuntimeClient;
import software.amazon.awssdk.services.sagemakerruntime.model.InvokeEndpointRequest;
import software.amazon.awssdk.services.sagemakerruntime.model.InvokeEndpointResponse;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CaptionServiceImpl implements CaptionService {

    private final ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    private final SageMakerRuntimeClient sageMakerRuntimeClient;

    @Override
    public String generateCaption(String imageUrl) throws JsonProcessingException {

        Map<String, Object> payload = new HashMap<>();
        payload.put("inputs", imageUrl);

        String payloadString = mapper.writeValueAsString(payload);


        InvokeEndpointRequest invokeRequest = InvokeEndpointRequest.builder()
                .endpointName("<ENDPOINT_NAME>")
                .body(SdkBytes.fromUtf8String(payloadString))
                .build();

        InvokeEndpointResponse invokeEndpointResponse = sageMakerRuntimeClient.invokeEndpoint(invokeRequest);


        return invokeEndpointResponse.body().asUtf8String();
    }
}
