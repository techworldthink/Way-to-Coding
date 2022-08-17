package com.example.cts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.cts.entity.AuthResponse;



@FeignClient(url="${auth.url}" , name="authapp")
public interface AuthClient {

	@GetMapping(value = "/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") final String token) throws Exception;
}
