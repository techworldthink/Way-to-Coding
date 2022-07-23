package com.spring.boot.learn.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("name")
public class TodoController {

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;

	@RequestMapping("todos")
	//http://localhost:8080/todos
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("abc");
		model.addAttribute("todos", todos);

		return "listTodos";
	}

}
