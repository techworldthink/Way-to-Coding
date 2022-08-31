package com.project.manager.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.manager.client.UserDetailsClient;
import com.project.manager.entity.Employee;
import com.project.manager.exception.EmployeeEmptyException;
import com.project.manager.exception.EmployeeNotFoundException;

@SpringBootTest
public class ManagerServiceTest {

	@MockBean
	private UserDetailsClient userDetailsClient;

	@InjectMocks
	private ManagerService managerService;

	private Employee emp0;
	private Employee emp1;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		emp0 = new Employee(1, "user0", "U", "user0@gmail.com", "2022-02-02", "2022-02-02", "Manager", "", true, true,
				false);
		emp1 = new Employee(2, "user1", "U", "user1@gmail.com", "2022-02-02", "2022-02-02", "Manager", "", true, true,
				false);

	}

	@Test
	@DisplayName("Test User Details Client")
	void testUserDetailsClientNotNull() {
		assertThat(userDetailsClient).isNotNull();
	}

	@Test
	@DisplayName("Test Manager Service")
	void testManagerServiceNotNull() {
		assertThat(managerService).isNotNull();
	}

	@Test
	@DisplayName("Test getAllManagers() in ManagerService")
	public void testGetAllManagers() throws EmployeeEmptyException {
		when(userDetailsClient.getEmployee()).thenReturn(Arrays.asList(emp0));
		assertThat(managerService.getAllManagers()).isNotNull();
	}

	@Test
	@DisplayName("Test getManagerById() in ManagerService")
	public void testGetManagerById() throws Exception {
		when(userDetailsClient.getEmployeeById(anyInt())).thenReturn(emp0);
		assertThat(managerService.getManagerById(1)).isNotNull();
	}

	@Test
	@DisplayName("Test deleteManagerById() in ManagerService")
	public void testDeleteManagerById() throws Exception {
		when(userDetailsClient.deleteEmployee(anyInt(), eq(true))).thenReturn(emp0);
		assertThat(managerService.deleteManagerById(1)).isNotNull();
	}

	@Test
	@DisplayName("Test addManager() in ManagerService")
	public void testAddManager() throws Exception {
		when(userDetailsClient.addEmployee(any(Employee.class))).thenReturn(emp0);
		assertThat(managerService.addManager(emp0)).isNotNull();
	}

	@Test
	@DisplayName("Test updateManager() in ManagerService")
	public void testUpdateManager() throws Exception {
		when(userDetailsClient.updateEmployee(anyInt(), any(Employee.class))).thenReturn(emp0);
		assertThat(managerService.updateManager(1, emp0)).isNotNull();
	}

}
