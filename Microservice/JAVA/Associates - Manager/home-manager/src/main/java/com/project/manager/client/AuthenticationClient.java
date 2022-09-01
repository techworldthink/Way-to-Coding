package com.project.manager.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.manager.entity.AuthResponse;

// @FeignClient(url = "${userauthentication.url}", name = "authapp-service")
@FeignClient(name = "authapp-service")
public interface AuthenticationClient {
	@GetMapping(value = "/authapp/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") final String token)
			throws Exception;
}
