package com.ms.sqsproducer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

@RestController
public class MessageController {

	@PostMapping("/sendmessage")
	public String sendMessage(@RequestBody String message) {
		Regions clientRegion = Regions.DEFAULT_REGION;
		final String accessKey = "(access id from aws)";
		final String secretAccessKey = "(secret access key from aws)";
		final String queueUrl = "(URL od SQS from aws)";

		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretAccessKey);

		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(clientRegion)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

		
		Map<String, MessageAttributeValue> messageAttributes = new HashMap<String, MessageAttributeValue>();
		messageAttributes.put("Name", new MessageAttributeValue().withStringValue("Cognizant").withDataType("String"));

		SendMessageRequest sendMessage = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(message)
				.withMessageAttributes(messageAttributes).withDelaySeconds(0);

		SendMessageResult result = sqs.sendMessage(sendMessage);
		System.out.println(result.getMessageId());
		return "Message sent";
	}
}
