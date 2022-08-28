package com.example.ctsproject.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="employee")
/*@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
<strong>@FilterDef(name = "deletedProductFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProductFilter", condition = "deleted = :isDeleted")</strong>*/
@ApiModel(value = "Model object that stores the Employee details.")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@NotNull(message = "First name is mandatory")
	@Size(min = 3, max = 20)
	private String firstName;
	
	@NotNull(message = "Last name is mandatory")
	@Size(min = 3, max = 20)
	private String lastName;
	
	@NotNull(message = "Email date is mandatory")
	@Pattern(regexp="\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")
	private String email;
	
	@NotNull(message = "Join date is mandatory")
	@Pattern(regexp="\\d{4}-\\d{2}-\\d{2}")
	private String joinDate;
	
	private String endDate;
	
	@NotNull(message = "Role is mandatory")
	@Size(min = 3, max = 20)
	private String role;
	
	private String mentorName;
	
	private boolean isHomeManager = true;
	
	private boolean status = true;
	
	private boolean isDeleted = false;
	
	
}
