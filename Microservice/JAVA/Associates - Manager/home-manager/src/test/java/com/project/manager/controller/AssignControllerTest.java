package com.project.manager.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.project.manager.client.AuthenticationClient;
import com.project.manager.entity.AssignManagers;
import com.project.manager.entity.AuthResponse;
import com.project.manager.service.AssignService;

@WebMvcTest(value = AssignController.class)
public class AssignControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AssignService assignService;

	@MockBean
	private AuthenticationClient authClient;

	private AssignManagers assign0;
	private AssignManagers assign1;
	private AuthResponse authOK;
	private AuthResponse authFailed;

	@BeforeEach
	public void setup() {

		assign0 = new AssignManagers(1, 2, 3, Instant.now());
		assign1 = new AssignManagers(2, 4, 5, Instant.now());
		authOK = new AuthResponse("1", "user", true, "");
		authFailed = new AuthResponse("", "", false, "");

	}

	@Test
	@DisplayName("Test Authorising client")
	void testClientNotNull() {
		assertThat(authClient).isNotNull();
	}

	@Test
	@DisplayName("Test Mock MVC client")
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}

	@Test
	@DisplayName("Test AssignService client")
	void testServiceNotNull() {
		assertThat(assignService).isNotNull();
	}
	
	@Test
	@DisplayName("Test getAllAssigns() of the AssignController with valid token ")
	void testgetAllAssignsWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(assignService.getAllAssigns()).thenReturn(Arrays.asList(assign0,assign1));
		this.mockMvc.perform(get("/assign/view/all").header("Authorization", "@uthoriz@tionToken123"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(2)));
		verify(assignService, times(1)).getAllAssigns();

	}
}
