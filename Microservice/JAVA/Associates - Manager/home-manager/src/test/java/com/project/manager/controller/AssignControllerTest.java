package com.project.manager.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
		when(assignService.getAllAssigns()).thenReturn(Arrays.asList(assign0, assign1));
		this.mockMvc.perform(get("/assign/view/all").header("Authorization", "@uthoriz@tionToken123"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(2)));
		verify(assignService, times(1)).getAllAssigns();

	}

	@Test
	@DisplayName("Test getAllAssigns() of the AssignController without valid token ")
	void testgetAllAssignsWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		this.mockMvc.perform(get("/assign/view/all").header("Authorization", "wrongtoken"))
				.andExpect(status().isForbidden());

	}

	@Test
	@DisplayName("Test getAllAssigns() of the AssignController without token ")
	void testgetAllAssignsWithoutToken() throws Exception {
		this.mockMvc.perform(get("/assign/view/all")).andExpect(status().isNotFound());

	}

	@Test
	@DisplayName("Test getAssignById() of the AssignController with valid token ")
	void testgetAssignByIdWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(assignService.getAssignsById(eq(1))).thenReturn(assign0);
		this.mockMvc.perform(get("/assign/view/{id}", 1).header("Authorization", "@uthoriz@tionToken123"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(4)))
				.andExpect(jsonPath("$.assignId", is(1)));
		verify(assignService, times(1)).getAssignsById(eq(1));

	}

	@Test
	@DisplayName("Test getAssignById() of the AssignController without valid token ")
	void testgetAssignByIdWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		this.mockMvc.perform(get("/assign/view/{id}", 1).header("Authorization", "wrongtoken"))
				.andExpect(status().isForbidden());
		verify(assignService, times(0)).getAssignsById(anyInt());

	}

	@Test
	@DisplayName("Test getAssignById() of the AssignController without token ")
	void testgetAssignByIdWithoutToken() throws Exception {
		this.mockMvc.perform(get("/assign/view/{id}", 1)).andExpect(status().isNotFound());
		verify(assignService, times(0)).getAssignsById(anyInt());

	}

	@Test
	@DisplayName("Test assignManager() of the AssignController with valid token ")
	void testassignManagerWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(assignService.assignManager(any(AssignManagers.class))).thenReturn(assign0);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(assign0);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/assign/add").header("Authorization", "@uthoriz@tionToken123")
						.contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(4)))
				.andExpect(jsonPath("$.assignId", is(1)));
		verify(assignService, times(1)).assignManager(any(AssignManagers.class));

	}

	@Test
	@DisplayName("Test assignManager() of the AssignController without valid token ")
	void testassignManagerWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		when(assignService.assignManager(any(AssignManagers.class))).thenReturn(assign0);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(assign0);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/assign/add").header("Authorization", "wrongtoken")
				.contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isForbidden());
		verify(assignService, times(0)).assignManager(any(AssignManagers.class));

	}

	@Test
	@DisplayName("Test assignManager() of the AssignController without token ")
	void testassignManagerWithoutToken() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(assign0);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/assign/add").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isNotFound());
		verify(assignService, times(0)).assignManager(any(AssignManagers.class));

	}

	@Test
	@DisplayName("Test deleteAssignById() of the AssignController with valid token ")
	void testdeleteAssignsByIdWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(assignService.deleteAssignsById(eq(1))).thenReturn(assign0);
		this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/assign/delete/{id}", 1).header("Authorization",
						"@uthoriz@tionToken123"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(4)))
				.andExpect(jsonPath("$.assignId", is(1)));
		verify(assignService, times(1)).deleteAssignsById(eq(1));

	}

	@Test
	@DisplayName("Test deleteAssignById() of the AssignController without valid token ")
	void testdeleteAssignsByIdWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/assign/delete/{id}", 1).header("Authorization", "wrongtoken"))
				.andExpect(status().isForbidden());
		verify(assignService, times(0)).deleteAssignsById(eq(1));

	}

	@Test
	@DisplayName("Test deleteAssignById() of the AssignController without token ")
	void testdeleteAssignsByIdWithoutToken() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/assign/delete/{id}", 1)).andExpect(status().isNotFound());
		verify(assignService, times(0)).deleteAssignsById(eq(1));

	}

	@Test
	@DisplayName("Test updateAssignedManager() of the AssignController with valid token ")
	void testupdateAssignedManagerWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(assignService.updateAssignedManager(anyInt(), any(AssignManagers.class))).thenReturn(assign0);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(assign0);
		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/assign/update/{id}", 1)
						.header("Authorization", "@uthoriz@tionToken123").contentType(MediaType.APPLICATION_JSON)
						.content(jsonString))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(4)))
				.andExpect(jsonPath("$.assignId", is(1)));
		verify(assignService, times(1)).updateAssignedManager(eq(1), any(AssignManagers.class));

	}

	@Test
	@DisplayName("Test updateAssignedManager() of the AssignController without valid token ")
	void testupdateAssignedManagerWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(assign0);
		this.mockMvc.perform(MockMvcRequestBuilders.put("/assign/update/{id}", 1).header("Authorization", "wrongtoken")
				.contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isForbidden());
		verify(assignService, times(0)).updateAssignedManager(anyInt(), any(AssignManagers.class));

	}

	@Test
	@DisplayName("Test updateAssignedManager() of the AssignController without token ")
	void testupdateAssignedManagerWithoutToken() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(assign0);
		this.mockMvc.perform(MockMvcRequestBuilders.put("/assign/update/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isNotFound());
		verify(assignService, times(0)).updateAssignedManager(anyInt(), any(AssignManagers.class));

	}

}
