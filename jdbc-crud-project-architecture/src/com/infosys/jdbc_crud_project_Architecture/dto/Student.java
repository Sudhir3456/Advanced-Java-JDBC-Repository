package com.infosys.jdbc_crud_project_Architecture.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



/**
 * Student is pojo class
 * @author Sudhir Kumar
 * 
 */

 


public class Student implements Serializable {

	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	private Long phone;

	public Student() {
		super();
	}

	public Student(int id, String name, String email, LocalDate dob, long phone ) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone ;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, email, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phone=" + phone + "]";
	}

}
