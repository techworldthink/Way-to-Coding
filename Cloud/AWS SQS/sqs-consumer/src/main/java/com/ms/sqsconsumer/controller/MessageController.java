package com.ms.sqsconsumer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;


@RestController
public class MessageController {

	@GetMapping("/readmessage")
	public String getMessage() {
		Regions clientRegion = Regions.DEFAULT_REGION;
		final String accessKey = "(access id from aws)";
		final String secretAccessKey = "(secret access key from aws)";
		final String queueUrl = "(URL od SQS from aws)";

		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretAccessKey);

		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(clientRegion)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest().withQueueUrl(queueUrl);
		receiveMessageRequest.setMaxNumberOfMessages(10);
		receiveMessageRequest.setWaitTimeSeconds(29);

		String response = "";
		while (true) {
			List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
			if (messages.size() > 0) {
				for (Message message : messages) {
					response += message.toString();
					sqs.deleteMessage(queueUrl, message.getReceiptHandle());
				}
			} else {
				break;
			}
		}

		return response;
	}
}
