package org.jsp.employeeapp.dao;


import javax.persistence.NoResultException;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.employeeapp.dto.Employee;
import org.hibernate.Transaction;

public class EmployeeDao {
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	
	public Employee  saveEmployee(Employee emp){
		
		s.save(emp);
		Transaction t = s.beginTransaction();
		t.commit();
		return emp;
		
		
		
	}
	
	public Employee updateEmployee(Employee emp) {
		s.update(emp);
		Transaction t=s.beginTransaction();
		t.commit();
		return emp;
		
		
	}
	
	public Employee findById(int id) {
		return s.get(Employee.class, id);
		
		
	}
	public Employee varifyEmployee(long phone,String password){
		String hql="select e from Employee e where e.phone=?1 and e.password=?2";
		Query<Employee> q =s.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		
		try {
			return q.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
	}
	
	public Employee varifyEmployee(int id,String password) {
		String hql = "select e from Employee e where .id=?1 and e.password=?2";
		Query<Employee> q= s.createQuery(hql);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		}
		catch (NoResultException e){
			return null;
			
		}
		
	}
	public Boolean deleteEmployee(int id) {
		Employee e=findById(id);
		if (e !=null) {
			Transaction t =s.beginTransaction();
			s.delete(e);
			t.commit();
			return true;
			
		}
		else {
			return false;
		}
	}
	 public List<Employee> findEmployeeBydeg(String desg){
		 String hql="Select e from employee e where e.desg=?1";
		 Query<Employee> q=s.createQuery(hql);
		 q.setParameter(1,desg);
		 return q.getResultList();
		 
		 
	 }
	
	
	
	
	

}
