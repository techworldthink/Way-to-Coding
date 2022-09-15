package com.project.manager.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.manager.client.UserDetailsClient;
import com.project.manager.entity.AssignManagers;
import com.project.manager.entity.Employee;
import com.project.manager.exception.AssignNotFoundException;
import com.project.manager.exception.EmployeeNotFoundException;
import com.project.manager.exception.InvalidReAssignException;
import com.project.manager.exception.ManagerNotFoundException;
import com.project.manager.repository.AssignedRepository;

@SpringBootTest
public class AssignServiceTest {

	@MockBean
	private UserDetailsClient userDetailsClient;

	@MockBean
	private AssignedRepository assignedRepository;

	@InjectMocks
	private AssignService assignService;

	private AssignManagers assign0;
	private AssignManagers assign1;
	private Employee userManager;
	private Employee userEmployee;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		assign0 = new AssignManagers(1, 1, 2, "12-12-2222");
		assign1 = new AssignManagers(2, 4, 5, "12-12-2222");
		userManager = new Employee(1, "user0", "U", "user0@gmail.com", "2022-02-02", "2022-02-02", "Manager", "", true,
				true, false);
		userEmployee = new Employee(2, "user1", "U", "user1@gmail.com", "2022-02-02", "2022-02-02", "Employee", "",
				false, true, false);
	}

	@Test
	@DisplayName("Test User Details Client")
	void testUserDetailsClientNotNull() {
		assertThat(userDetailsClient).isNotNull();

	}

	@Test
	@DisplayName("Test Assign Service")
	void testAssignServiceNotNull() {
		assertThat(assignService).isNotNull();

	}

	@Test
	@DisplayName("Test Assigned Repository")
	void testAssignedRepositoryNotNull() {
		assertThat(assignedRepository).isNotNull();

	}

	@Test
	@DisplayName("Test assignManager() of AssignService success")
	public void testAssignManagerAssignSuccess() throws Exception {
		when(userDetailsClient.getEmployeeById(eq(1), anyString())).thenReturn(userManager);
		when(userDetailsClient.getEmployeeById(eq(2), anyString())).thenReturn(userEmployee);
		when(assignedRepository.save(any(AssignManagers.class))).thenReturn(assign0);
		assertThat(assignService.assignManager(assign0, "token")).isNotNull();
	}

	@Test
	@DisplayName("Test assignManager() of AssignService failed - invalid home manager id")
	public void testAssignManagerAssignFailedDueToInvalidManagerId() throws Exception {
		when(userDetailsClient.getEmployeeById(eq(1), anyString())).thenReturn(userEmployee);
		when(userDetailsClient.getEmployeeById(eq(2), anyString())).thenReturn(userEmployee);
		when(assignedRepository.save(any(AssignManagers.class))).thenReturn(assign0);
		assertThrows(ManagerNotFoundException.class, () -> {
			assignService.assignManager(assign0, "token");
		});
	}

	@Test
	@DisplayName("Test assignManager() of AssignService failed - invalid employee id")
	public void testAssignManagerAssignFailedDueToInvalidEmployeeId() throws Exception {
		when(userDetailsClient.getEmployeeById(eq(1), anyString())).thenReturn(userManager);
		when(userDetailsClient.getEmployeeById(eq(2), anyString())).thenReturn(userManager);
		when(assignedRepository.save(any(AssignManagers.class))).thenReturn(assign0);
		assertThrows(EmployeeNotFoundException.class, () -> {
			assignService.assignManager(assign0, "token");
		});
	}

	@Test
	@DisplayName("Test assignManager() of AssignService failed - Already assigned")
	public void testAssignManagerAssignFailedDueToExistingEntry() throws Exception {
		when(userDetailsClient.getEmployeeById(eq(1), anyString())).thenReturn(userManager);
		when(userDetailsClient.getEmployeeById(eq(2), anyString())).thenReturn(userEmployee);
		when(assignedRepository.existsByEmployeeId(anyInt())).thenReturn(true);
		when(assignedRepository.save(any(AssignManagers.class))).thenReturn(assign0);
		assertThrows(InvalidReAssignException.class, () -> {
			assignService.assignManager(assign0, "token");
		});
	}

	@Test
	@DisplayName("Test getAllAssigns() of AssignService")
	public void testGetAllAssigns() throws Exception {
		when(assignedRepository.findAll()).thenReturn(Arrays.asList(assign0, assign1));
		assertThat(assignService.getAllAssigns()).isNotNull();
	}

	@Test
	@DisplayName("Test getAssignsById() of AssignService - Found")
	public void testGetAssignsByIdFound() throws Exception {
		Optional<AssignManagers> assign2 = Optional.of(assign0);
		when(assignedRepository.findById(anyInt())).thenReturn(assign2);
		assertThat(assignService.getAssignsById(1)).isNotNull();
	}

	@Test
	@DisplayName("Test getAssignsById() of AssignService - Not Found Exception")
	public void testGetAssignsByIdNotFound() throws Exception {
		assertThrows(AssignNotFoundException.class, () -> {
			assignService.getAssignsById(1);
		});
	}

	@Test
	@DisplayName("Test deleteAssignsById() of AssignService - Success")
	public void testdeleteAssignsByIdSuccess() throws Exception {
		Optional<AssignManagers> assign2 = Optional.of(assign0);
		when(assignedRepository.findById(anyInt())).thenReturn(assign2);
		assertThat(assignService.deleteAssignsById(1)).isNotNull();
		verify(assignedRepository, times(1)).deleteById(anyInt());
	}

	@Test
	@DisplayName("Test deleteAssignsById() of AssignService - Assign Not found")
	public void testdeleteAssignsByIdAssignNotFound() throws Exception {
		assertThrows(AssignNotFoundException.class, () -> {
			assignService.deleteAssignsById(1);
		});
		verify(assignedRepository, times(0)).deleteById(anyInt());
	}

	@Test
	@DisplayName("Test updateAssignedManager() of AssignService success")
	public void testUpdateAssignedManagerSuccess() throws Exception {
		Optional<AssignManagers> assign2 = Optional.of(assign0);
		when(assignedRepository.findById(anyInt())).thenReturn(assign2);
		when(userDetailsClient.getEmployeeById(eq(1), anyString())).thenReturn(userManager);
		when(assignedRepository.save(any(AssignManagers.class))).thenReturn(assign0);
		assertThat(assignService.updateAssignedManager(1, assign0, anyString())).isNotNull();
		verify(assignedRepository, times(1)).save(any(AssignManagers.class));
	}

	@Test
	@DisplayName("Test updateAssignedManager() of AssignService - Assign Not Found Exception")
	public void testUpdateAssignedManagerAssignNotFoundException() throws Exception {
		assertThrows(AssignNotFoundException.class, () -> {
			assignService.updateAssignedManager(1, assign0, anyString());
		});
		verify(assignedRepository, times(0)).save(any(AssignManagers.class));
	}

	@Test
	@DisplayName("Test updateAssignedManager() of AssignService failed - invalid home manager id")
	public void testupdateAssignedManagerFailedDueToInvalidManagerId() throws Exception {
		Optional<AssignManagers> assign2 = Optional.of(assign0);
		when(assignedRepository.findById(anyInt())).thenReturn(assign2);
		when(userDetailsClient.getEmployeeById(eq(1), anyString())).thenReturn(userEmployee);
		when(assignedRepository.save(any(AssignManagers.class))).thenReturn(assign0);
		assertThrows(ManagerNotFoundException.class, () -> {
			assignService.updateAssignedManager(1, assign0, "token");
		});
	}

}
