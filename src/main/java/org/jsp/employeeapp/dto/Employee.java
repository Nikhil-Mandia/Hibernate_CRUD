package org.jsp.employeeapp.dto;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true)
	private long Phone;
	@Column(nullable = false)
	private String Desg;
	@Column(nullable = false)
	private Double Sal;
	@Column(nullable = false)
	private String Password;
	
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
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getDesg() {
		return Desg;
	}
	public void setDesg(String desg) {
		Desg = desg;
	}
	public Double getSal() {
		return Sal;
	}
	public void setSal(Double sal) {
		Sal = sal;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	

}
