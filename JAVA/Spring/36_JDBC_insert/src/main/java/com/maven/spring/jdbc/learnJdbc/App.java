package com.maven.spring.jdbc.learnJdbc;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/jdbc/learnJdbc/config.xml");
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		JdbcTemplate obj = new JdbcTemplate(ds);
		String sql = "insert into employee values(?,?,?)";
		int result = obj.update(sql, 2, "b", "b");
		System.out.println("Number of records are inserted : " + result);

		((AbstractApplicationContext) ctx).close();
	}
}
