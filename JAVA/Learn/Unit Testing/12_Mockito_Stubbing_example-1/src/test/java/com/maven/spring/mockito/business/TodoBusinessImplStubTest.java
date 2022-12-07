package com.maven.spring.mockito.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.maven.spring.business.TodoBusinessImpl;
import com.maven.spring.data.api.TodoService;
import com.maven.spring.mockito.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("dummy");
		assertEquals(2, todos.size());
	}

}
