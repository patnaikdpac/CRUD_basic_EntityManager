package com.deepak.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveEmp(@RequestBody Employee employee) 
	{
		return employeeService.saveEmp(employee);
	}
	
	@GetMapping("/get")
	public ResponseEntity<Object> getEmp()
	{
		return employeeService.getEmp();
		
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> editEmp(@PathVariable Integer id, @RequestBody Employee employee)
	{
		return employeeService.editEmp(id, employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmp(@PathVariable Integer id)
	{
		return employeeService.deleteEmp(id);
	}
	
}
