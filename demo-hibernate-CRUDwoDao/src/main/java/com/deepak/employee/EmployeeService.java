package com.deepak.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

	ResponseEntity<Object> saveEmp(Employee employee);

	ResponseEntity<Object> getEmp();

	ResponseEntity<Object> editEmp(Integer id, Employee employee);

	ResponseEntity<Object> deleteEmp(Integer id);

}
