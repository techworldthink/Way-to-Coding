package com.maven.spring.core.stereotype.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ins")
@Scope("prototype")
public class Instructor {
	
	@Value("10")
	private int id;
	@Value("myname")
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
