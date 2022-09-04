package com.project.manager.feign.exceptions;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.manager.exception.AuthorizationException;
import com.project.manager.exception.ExceptionDetails;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
	private ErrorDecoder errorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		ExceptionDetails message = null;
		try {
			String bodyIs = response.body().asInputStream().toString();
			log.debug(bodyIs);
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//			message = mapper.readValue(bodyIs, ExceptionDetails.class);
//			log.debug(message.getMessage());
//			log.debug(message.getTimestamp());
//			log.debug(message.getCode().toString());
		} catch (IOException e) {
			return new Exception("IO Exception");
		}
		switch (response.status()) {
		case 400:
			return new Exception("Bad Request");
		case 404:
			return new Exception("Not found");
		case 403:
			return new AuthorizationException("Invalid token!");
		default:
			return new Exception("Error");
		// return new AuthorizationException("Invalid token!");
		}
	}

}