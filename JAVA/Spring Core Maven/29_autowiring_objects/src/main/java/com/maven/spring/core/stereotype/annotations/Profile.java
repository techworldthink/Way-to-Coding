package com.maven.spring.core.stereotype.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Profile {
	@Value("JAVA Architect")
	private String title;
	@Value("None")
	private String company;

	@Override
	public String toString() {
		return "Profile [title=" + title + ", company=" + company + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
