package org.jsp.employeeapp.controller;

import java.util.List;
import java.util.Scanner;
import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeController {
	static Scanner sc = new Scanner(System.in);
	static EmployeeDao dao = new EmployeeDao();

	public static void main(String[] args) {
		System.out.println("1. Save Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Find Employee by id");
		System.out.println("4. Verify Employee by Phone and Password");
		System.out.println("5. Verify Employee by id and Password");
		System.out.println("6. Delete Employee by id ");
		System.out.println("7. Find Employee by Designation");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:{
			save();
			break;
		}
		case 2:{
			update();
			break;
		}
		case 3:{
			findById();
			break;
		}
		case 4:{
			verifyByPhone();
			break;
		}
		case 5:{
			verifyByID();;
			break;
		}
		case 6:{
			delete();;
			break;
		}
		case 7:{
			findByDesignation();;
			break;
		}
		}

	}

	public static void save() {
		System.out.println("Enter the Employee name,desg,salary,phone and password to register");
		Employee e = new Employee();
		e.setName(sc.next());
		e.setDesg(sc.next());
		e.setSal(sc.nextDouble());
		e.setPhone(sc.nextLong());
		e.setPassword(sc.next());
		e = dao.saveEmployee(e);
		System.out.println("Employee save with id " + e.getId());

	}

	public static void update() {
		System.out.println("Enter the Employee ID which you want to update");
		int id = sc.nextInt();
		System.out.println("Enter the Employee name,desg,salary,phone and password to register");
		Employee e = new Employee();
		e.setName(sc.next());
		e.setDesg(sc.next());
		e.setSal(sc.nextDouble());
		e.setPhone(sc.nextLong());
		e.setPassword(sc.next());
		e = dao.updateEmployee(e);
		System.out.println("Employee save with id " + e.getId());

	}

	public static void verifyByPhone() {
		System.out.println("please Enter your PhoneNO & Password to verify");
		long Phone = sc.nextLong();
		String Password = sc.next();
		Employee e = dao.varifyEmployee(Phone, Password);
		if (e != null) {
			System.out.println("Emplyee ID " + e.getId());
			System.out.println("Emplyee Name " + e.getName());
			System.out.println("Emplyee Designation	 " + e.getDesg());
			System.out.println("Emplyee Sal " + e.getSal());
			System.out.println("Emplyee Phone " + e.getPhone());

		} else {
			System.err.println("Please Enter Valid Phone or Password");
		}

	}

	public static void verifyByID() {
		System.out.println("Please enter the ID & password");
		String Password = sc.next();
		int id = sc.nextInt();
		Employee e = dao.varifyEmployee(id, Password);
		if (e != null) {
			System.out.println("Emplyee ID " + e.getId());
			System.out.println("Emplyee Name " + e.getName());
			System.out.println("Emplyee Designation	 " + e.getDesg());
			System.out.println("Emplyee Sal " + e.getSal());
			System.out.println("Emplyee Phone " + e.getPhone());
		} else {
			System.err.println("Please Enter Valid Phone or Password");
		}

	}

	public static void delete() {
		System.out.println("Enter ID which you want to dlt");
		int id = sc.nextInt();
		boolean deleted = dao.deleteEmployee(id);
		if (deleted) {
			System.out.println("Employee deleted");
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}
	
	public static void findById() {
		System.out.println("Please ENter id You want to search");
		int id=sc.nextInt();
		Employee e=dao.findById(id);
		if(e!=null) {
			System.out.println("Emplyee ID " + e.getId());
			System.out.println("Emplyee Name " + e.getName());
			System.out.println("Emplyee Designation	 " + e.getDesg());
			System.out.println("Emplyee Sal " + e.getSal());
			System.out.println("Emplyee Phone " + e.getPhone());
		} else {
			System.err.println("Please Enter Valid Id");
		}
		

	}
	public static void findByDesignation(){
		System.out.println("Please enter Designation you want to search");
		String desg=sc.next();
		List<Employee> emps=dao.findEmployeeBydeg(desg);
		if(emps.size()>0) {
			for(Employee e:emps)
			{
				System.out.println("Employee Id:" + e.getId());
				System.out.println("Employee Name:" + e.getName());
				System.out.println("Designtaion:" + e.getDesg());
				System.out.println("Salary:" + e.getSal());
				System.out.println("Phone Number:" + e.getPhone());
			}
		} else {
			System.err.println("No employee found with entered designtaion");
		}
			
		}
		
		
	}


