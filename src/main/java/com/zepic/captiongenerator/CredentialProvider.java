package com.zepic.captiongenerator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sagemakerruntime.SageMakerRuntimeClient;

@Configuration
public class CredentialProvider {


    private static final String ACCESS_KEY_ID = "<ACCESS_KEY_ID>";
    private static final String SECRET_ACCESS_KEY = "<SECRET_KEY_ID>";
    private static final String SESSION_TOKEN = "<SESSION_TOKEN>";

    @Bean(name="sageMakerClient")
    public SageMakerRuntimeClient sageMakerRuntimeClient() {
        AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(AwsSessionCredentials.create(ACCESS_KEY_ID, SECRET_ACCESS_KEY, SESSION_TOKEN));

        return SageMakerRuntimeClient.builder()
                .region(Region.US_WEST_2)
                .credentialsProvider(credentialsProvider).build();
    }

}
