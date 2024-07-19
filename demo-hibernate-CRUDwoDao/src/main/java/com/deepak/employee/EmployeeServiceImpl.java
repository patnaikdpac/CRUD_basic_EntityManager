package com.deepak.employee;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public ResponseEntity<Object> saveEmp(Employee employee) 
	{
		Map<String, Object> response = new LinkedHashMap<>();
		
		employee.setCreUser("Admin");
		employee.setModUser("Deepak");
		
		String message = employeeRepository.saveEmp(employee);
		
		if(message.equals("Success"))
		{
			response.put("Status", "OK");
			response.put("message", "Data Inserted Successfully!!");
		}
		else
		{
			response.put("Status", "ERROR!!");
			response.put("message",	message);
		}
		
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	public ResponseEntity<Object> getEmp()
	{
		return employeeRepository.getEmp();
	}
	@Override
	public ResponseEntity<Object> editEmp(Integer id, Employee employee)
	{
		Map<String, Object> response = new LinkedHashMap<>();
		HttpStatus status = null;
		
		String message = employeeRepository.editEmp(id,employee);
		
		if(message.equals("Success"))
		{
			status = HttpStatus.OK;
			response.put("Status", "OK");
			response.put("message", "Data Inserted Successfully!!");
		}
		else
		{
			status = HttpStatus.NOT_FOUND;
			response.put("Status", "ERROR!!");
			response.put("message",	message);
		}
		
		return new ResponseEntity<Object>(response, status);
	}
	
	@Override
	public ResponseEntity<Object> deleteEmp(Integer id)
	{
		Map<String, Object> response = new LinkedHashMap<>();
		HttpStatus status = null;
		
		String message = employeeRepository.deleteEmp(id);
		
		if(message.equals("Success"))
		{
			status = HttpStatus.OK;
			response.put("Status", "OK");
			response.put("message", "Data Inserted Successfully!!");
		}
		else
		{
			status = HttpStatus.NOT_FOUND;
			response.put("Status", "ERROR!!");
			response.put("message",	message);
		}
		
		return new ResponseEntity<Object>(response, status);
	}

}
