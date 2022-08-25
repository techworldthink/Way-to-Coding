package com.project.manager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.project.manager.entity.HomeManager;
import com.project.manager.repository.ManagerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceTest {

	@Autowired
	private ManagerService managerService;

	@MockBean
	private ManagerRepository managerRepository;

	@Test
	public void getManagerListTest() {
		when(managerRepository.findAll()).thenReturn(Stream
				.of(new HomeManager(3, "Jobin", "J", Instant.now()), new HomeManager(3, "Jobin", "J", Instant.now()))
				.collect(Collectors.toList()));
		assertEquals(2, managerService.getAllManagers().size());
	}

}
