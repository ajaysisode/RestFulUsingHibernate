package com.bikkadit.RestFulUsingHibernate.Service;

import java.util.List;

import com.bikkadit.RestFulUsingHibernate.Model.Employee;

public interface EmpServiceI {
	
	
	public int addEmplyee(Employee em);
	
	public List<Employee> getAllempdata();
	
	public Employee loginCheck(Employee employee);
	
	public Employee editUser(int empId);
	
	public Employee update(Employee user);
	
	public Employee delete(int uid);
}
