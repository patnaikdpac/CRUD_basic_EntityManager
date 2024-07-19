package com.deepak.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EmployeeRepository 
{
	@Autowired
	EntityManager em;
	
	public String saveEmp(Employee employee) 
	{
		String message = null;
		try 
		{
			em.persist(employee);
			if(employee.getId() != null)
				message = "Success";
		} 
		catch (DataIntegrityViolationException e) 
		{
			message = e.getMessage();
		}
		return message;
	}
	
	
	public String editEmp(Integer id, Employee employee)
	{
		String message = null;
		Employee existEmp = em.find(Employee.class, id);
		if(existEmp != null)
		{
			existEmp.setFirstName(employee.getFirstName());
			existEmp.setLastName(employee.getLastName());
			existEmp.setMail(employee.getMail());
			existEmp.setMobile(employee.getMobile());
			existEmp.setModUser("Deepak");
			
			em.merge(existEmp);
			message = "Success";
		}
		else
		{
			message = "Employee Not Found!!!";
		}
		
		return message;
	}


	public ResponseEntity<Object> getEmp() 
	{
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
		List<Employee> resultList = query.getResultList();
		return new ResponseEntity<Object>(resultList,HttpStatus.OK);
	}


	public String deleteEmp(Integer id) 
	{
		int result = em.createNativeQuery("delete from employee where emp_id = " + id).executeUpdate();
		if(result>0)
			return "Success";
		else
			return "Delete unsuccessful!!";
	}

}
