package com.g2c6.kafkaconsumer.service;

import java.io.ByteArrayInputStream;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

	Regions clientRegion = Regions.DEFAULT_REGION;
	final String accessKey = "(goto security credentials page -> create access key)";
	final String secretAccessKey = "(goto security credentials page -> create access key)";
	//final String END_POINT = "https://s3.wasabisys.com";

	AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretAccessKey);

	AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion)
			.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

	TransferManager mgr = TransferManagerBuilder.standard().withS3Client(s3Client).build();

	@KafkaListener(topics = "first-topic", groupId = "group_id")
	public void consumeMessage(String employee) throws JsonProcessingException {
		System.out.println(employee);
		ObjectMapper mapper = new ObjectMapper();
		byte[] arr = mapper.writeValueAsBytes(employee);
		ObjectMetadata omd = new ObjectMetadata();
		omd.setContentLength(arr.length);
		try {
			mgr.upload("g2-c6-kafka", "myfile.json", new ByteArrayInputStream(arr), omd);
			System.out.println("Success");
			//System.out.println(clientRegion);
		} catch (AmazonServiceException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (SdkClientException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
