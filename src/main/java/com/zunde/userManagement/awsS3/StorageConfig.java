package com.zunde.userManagement.awsS3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.access-secret}")
    private String accessSecret;

    @Value("${cloud.aws.region.static}")
    private String region;

    public AmazonS3 generateUser(){
        AWSCredentials credentials = new BasicAWSCredentials(accessKey,accessSecret);
        return   AmazonS3ClientBuilder.
                standard().
                withCredentials(new AWSStaticCredentialsProvider(credentials)).
                withRegion(region)
                .build();
    }


}
