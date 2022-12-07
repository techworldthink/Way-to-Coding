package com.maven.spring.mockito.data.stub;

import java.util.Arrays;
import java.util.List;

import com.maven.spring.data.api.TodoService;

public class TodoServiceStub implements TodoService {
	public List<String> retrieveTodos(String user) {
		if (user.equals("dummy")) {
			return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		} else if (user.equals("dummy1")) {
			return Arrays.asList();
		}
		return null;

	}
}
