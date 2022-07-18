package com.maven.spring.core.stereotype.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ins")
@Scope("prototype")
public class Instructor {
	private int id;
	private String name;

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
