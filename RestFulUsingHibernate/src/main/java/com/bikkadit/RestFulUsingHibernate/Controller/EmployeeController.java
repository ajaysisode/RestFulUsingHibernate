package com.bikkadit.RestFulUsingHibernate.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bikkadit.RestFulUsingHibernate.Model.Employee;
import com.bikkadit.RestFulUsingHibernate.Service.EmpServiceI;

public class EmployeeController {
	@Autowired
	private EmpServiceI empServiceI;

	@PostMapping(value = "/addemployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		int addEmplyee = empServiceI.addEmplyee(employee);
		System.out.println(addEmplyee);
		return new ResponseEntity<>("id created" + employee.getEmpId(), HttpStatus.CREATED);
	}

	@GetMapping(value = "/getById/{id}", produces = "application/json")
	public ResponseEntity<Employee> getById(@PathVariable int id) {
		Employee byIdEm = empServiceI.getByIdEm(id);
		return new ResponseEntity<Employee>(byIdEm, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllEM", produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEM(List<Employee> employees) {
		List<Employee> allempdata = empServiceI.getAllempdata(employees);
		return new ResponseEntity<List<Employee>>(allempdata, HttpStatus.OK);
	}

	@GetMapping(value = "/loginCheck/{id}/{name}", produces = "application/json")
	public ResponseEntity<Employee> loginCheck(@PathVariable Integer id, @PathVariable String name) {

		Employee findByEmpIDAndEmpName = empServiceI.loginCheck(id, name);

		if (findByEmpIDAndEmpName == null) {

			return new ResponseEntity<Employee>(findByEmpIDAndEmpName, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(findByEmpIDAndEmpName, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		int addEmplyee = empServiceI.addEmplyee(employee);
		System.out.println(addEmplyee);
		return new ResponseEntity<>("id created" + employee.getEmpId(), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteById/{id}", produces = "application/json")
	public ResponseEntity<Employee> deleteById(@PathVariable int id) {
		Employee byIdEm = empServiceI.getByIdEm(id);
		return new ResponseEntity<Employee>(byIdEm, HttpStatus.OK);
	}
}
