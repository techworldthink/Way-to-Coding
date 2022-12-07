package com.maven.spring.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.maven.spring.business.TodoBusinessImpl;
import com.maven.spring.data.api.TodoService;

public class TodoBusinessImplMockitoTest {

	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		// given
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

		// when
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");

		// then
		assertThat(todos.size(), is(2));
	}
}
