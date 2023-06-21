package com.travel.travtronics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
    
    @Bean
	public AmazonS3 amazonS3Client(@Value("${cloud.aws.credentials.accessKey}") String accessKey,
			@Value("${cloud.aws.credentials.secretKey}") String secretKey,
			@Value("${cloud.aws.region.static}") String region) {

		return AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
				.withRegion(region).build();
	}

}
