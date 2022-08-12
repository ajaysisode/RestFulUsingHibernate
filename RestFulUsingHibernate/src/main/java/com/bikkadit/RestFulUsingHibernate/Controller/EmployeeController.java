package com.bikkadit.RestFulUsingHibernate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bikkadit.RestFulUsingHibernate.Model.Employee;
import com.bikkadit.RestFulUsingHibernate.Service.EmpServiceI;


public class EmployeeController {
	@Autowired
	private EmpServiceI empServiceI;
	@PostMapping(value="/addemployee",consumes ="application/json",produces = "application/json")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		int addEmplyee = empServiceI.addEmplyee(employee);
		System.out.println(addEmplyee);
		return new ResponseEntity<>("id created"+employee.getEmpId(),HttpStatus.OK);
		
	}
}
