package com.maven.spring.jdbc.learnJdbc.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.maven.spring.jdbc.learnJdbc.employee.dao.EmployeeDao;
import com.maven.spring.jdbc.learnJdbc.employee.dao.rowmapper.EmployeeRowMapper;
import com.maven.spring.jdbc.learnJdbc.employee.dto.Employee;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Employee employee) {
		String sql = "insert into employee values(?,?,?)";
		int result = jdbcTemplate.update(sql, employee.getId(), employee.getFirstname(), employee.getLastname());
		return result;
	}

	@Override
	public int update(Employee employee) {
		String sql = "update employee set firstname=?,lastname=? where id=?";
		int result = jdbcTemplate.update(sql, employee.getFirstname(), employee.getLastname(), employee.getId());
		return result;
	}

	@Override
	public int delete(Employee employee) {
		String sql = "delete from  employee where id=?";
		int result = jdbcTemplate.update(sql, employee.getId());
		return result;
	}

	@Override
	public Employee read(int id) {
		String sql = "select * from employee where id=?";
		EmployeeRowMapper rowmapper = new EmployeeRowMapper();
		Employee employee = jdbcTemplate.queryForObject(sql, rowmapper, id);
		return employee;
	}

	@Override
	public List<Employee> read() {
		String sql = "select * from employee";
		EmployeeRowMapper rowmapper = new EmployeeRowMapper();
		List<Employee> employees = jdbcTemplate.query(sql, rowmapper);
		return employees;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
