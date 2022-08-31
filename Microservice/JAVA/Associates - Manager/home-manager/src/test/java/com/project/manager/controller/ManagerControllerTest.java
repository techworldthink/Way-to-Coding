package com.project.manager.controller;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.manager.client.AuthenticationClient;
import com.project.manager.entity.AuthResponse;
import com.project.manager.entity.Employee;
import com.project.manager.service.ManagerService;

@WebMvcTest(value = ManagerController.class)
public class ManagerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ManagerService managerService;

	@MockBean
	private AuthenticationClient authClient;

	private Employee emp0;
	private Employee emp1;
	private Employee emp2;
	private AuthResponse authOK;
	private AuthResponse authFailed;

	@BeforeEach
	public void setup() {

		emp0 = new Employee(1, "user0", "U", "user0@gmail.com", "2022-02-02", "2022-02-02", "Manager", "", true, true,
				false);
		emp1 = new Employee(2, "user1", "U", "user1@gmail.com", "2022-02-02", "2022-02-02", "Manager", "", true, true,
				false);
		emp2 = new Employee(3, "user2", "U", "user2@gmail.com", "2022-03-03", "2022-03-03", "Employee", "", false, true,
				false);
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
	@DisplayName("Test ManagerService client")
	void testServiceNotNull() {
		assertThat(managerService).isNotNull();
	}

	@Test
	@DisplayName("Test getAllManagers() of the Controller with valid token ")
	void testgetAllManagersWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(managerService.getAllManagers()).thenReturn(Arrays.asList(emp0, emp1));
		this.mockMvc.perform(get("/managers/view/all").header("Authorization", "@uthoriz@tionToken123"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(2)));
		verify(managerService, times(1)).getAllManagers();

	}

	@Test
	@DisplayName("Test getAllManagers() of the Controller without valid token ")
	void testgetAllManagersWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		this.mockMvc.perform(get("/managers/view/all").header("Authorization", "wrongtoken"))
				.andExpect(status().isForbidden());
	}

	@Test
	@DisplayName("Test getAllManagers() of the Controller without token ")
	void testgetAllManagersWithoutToken() throws Exception {
		this.mockMvc.perform(get("/managers/view/all")).andExpect(status().isNotFound());
	}

	@Test
	@DisplayName("Test getAllManagers() of the Controller with valid token ")
	void testgetManagerByIdWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(managerService.getManagerById(anyInt())).thenReturn(emp0);
		this.mockMvc.perform(get("/managers/view/1").header("Authorization", "@uthoriz@tionToken123"))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.empId", is(1)));
		verify(managerService, times(1)).getManagerById(eq(1));
	}

	@Test
	@DisplayName("Test getAllManagers() of the Controller without valid token ")
	void testgetManagerByIdWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		when(managerService.getManagerById(anyInt())).thenReturn(emp0);
		this.mockMvc.perform(get("/managers/view/1").header("Authorization", "wrongtoken"))
				.andExpect(status().isForbidden());
	}

	@Test
	@DisplayName("Test getAllManagers() of the Controller without token ")
	void testgetManagerByIdWithoutToken() throws Exception {
		this.mockMvc.perform(get("/managers/view/1")).andExpect(status().isNotFound());
	}

	@Test
	@DisplayName("Test deleteManagerById() of the Controller with valid token ")
	void testdeleteManagerByIdWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(managerService.deleteManagerById(anyInt())).thenReturn(emp0);
		this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/managers/delete/{id}", 1).header("Authorization",
						"@uthoriz@tionToken123"))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.empId", is(1)));
		verify(managerService, times(1)).deleteManagerById(eq(1));
	}

	@Test
	@DisplayName("Test deleteManagerById() of the Controller with Invalid token ")
	void testdeleteManagerByIdWithInvalidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		when(managerService.deleteManagerById(anyInt())).thenReturn(emp0);
		this.mockMvc
				.perform(
						MockMvcRequestBuilders.delete("/managers/delete/{id}", 1).header("Authorization", "wrongtoken"))
				.andExpect(status().isForbidden());
	}

	@Test
	@DisplayName("Test deleteManagerById() of the Controller without token ")
	void testdeleteManagerByIdWithoutToken() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/managers/delete/{id}", 1))
				.andExpect(status().isNotFound());
	}

	@Test
	@DisplayName("Test addManager() of the Controller with valid token ")
	void testaddManagerWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(managerService.addManager(any(Employee.class))).thenReturn(emp0);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(emp0);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/managers/add").header("Authorization", "@uthoriz@tionToken123")
						.contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.empId", is(1)));
		verify(managerService, times(1)).addManager(any(Employee.class));
	}

	@Test
	@DisplayName("Test addManager() of the Controller without valid token ")
	void testaddManagerWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(emp0);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/managers/add").header("Authorization", "wrongtoken")
				.contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isForbidden());
		verify(managerService, times(0)).addManager(any(Employee.class));
	}

	@Test
	@DisplayName("Test addManager() of the Controller without token ")
	void testaddManagerWithoutToken() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(emp0);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/managers/add").contentType(MediaType.APPLICATION_JSON)
				.content(jsonString)).andExpect(status().isNotFound());
	}

	@Test
	@DisplayName("Test updateManager() of the Controller with valid token ")
	void testupdateManagerWithValidToken() throws Exception {
		when(authClient.getValidity("@uthoriz@tionToken123"))
				.thenReturn(new ResponseEntity<AuthResponse>(authOK, HttpStatus.OK));
		when(managerService.updateManager(anyInt(), any(Employee.class))).thenReturn(emp0);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(emp0);
		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/managers/update/{id}", 1)
						.header("Authorization", "@uthoriz@tionToken123").contentType(MediaType.APPLICATION_JSON)
						.content(jsonString))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.empId", is(1)));
		verify(managerService, times(1)).updateManager(anyInt(), any(Employee.class));
	}

	@Test
	@DisplayName("Test updateManager() of the Controller without valid token ")
	void testupdateManagerWithoutValidToken() throws Exception {
		when(authClient.getValidity("wrongtoken"))
				.thenReturn(new ResponseEntity<AuthResponse>(authFailed, HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(emp0);
		this.mockMvc.perform(MockMvcRequestBuilders.put("/managers/update/{id}", 1)
				.header("Authorization", "wrongtoken").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isForbidden());
		verify(managerService, times(0)).updateManager(anyInt(), any(Employee.class));
	}

	@Test
	@DisplayName("Test updateManager() of the Controller without token ")
	void testupdateManagerWithoutToken() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(emp0);
		this.mockMvc.perform(MockMvcRequestBuilders.put("/managers/update/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isNotFound());
		verify(managerService, times(0)).updateManager(anyInt(), any(Employee.class));
	}

}
