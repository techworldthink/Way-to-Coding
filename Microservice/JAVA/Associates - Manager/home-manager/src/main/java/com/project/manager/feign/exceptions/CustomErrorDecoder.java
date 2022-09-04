package com.project.manager.feign.exceptions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.io.CharStreams;
import com.project.manager.exception.AuthorizationException;
import com.project.manager.exception.ExceptionDetails;

import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.*;
import org.springframework.context.annotation.Configuration;


public class CustomErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder errorDecoder = new Default();

	@SuppressWarnings("deprecation")
	@Override
	public Exception decode(String s, Response response) {

		String message = null;
		InputStream result = null;

		try {
			// reader = response.body().asReader();
			result = response.body().asInputStream();
			// Easy way to read the stream and get a String object
			// String result = CharStreams.toString(reader);
			// use a Jackson ObjectMapper to convert the Json String into a
			// Pojo
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			// just in case you missed an attribute in the Pojo
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			// mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			// init the Pojo
			// ExceptionDetails exceptionMessage = mapper.readValue(result,
			// ExceptionDetails.class);
			ExceptionDetails exceptionMessage = mapper.readValue(result, ExceptionDetails.class);

			message = exceptionMessage.getMessage();

		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			// It is the responsibility of the caller to close the stream.
			try {

				if (result != null)
					result.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		switch (response.status()) {
		case 403:
			return new AuthorizationException("Forbidden access");
		default:
			return new Exception("Error");

		}

		// return errorDecoder.decode(s, response);
	}
}