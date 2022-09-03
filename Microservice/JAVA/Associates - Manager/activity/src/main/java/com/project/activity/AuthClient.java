package com.project.activity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.activity.entity.AuthResponse;

@FeignClient(url = "${auth.url}", name = "authapp")
public interface AuthClient {
	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") final String token)
			throws Exception;
}
