package org.springfm.action;

import org.springfm.beans.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAction {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
		Employee employee = applicationContext.getBean("employee", Employee.class);
		System.out.println("Employe Id "+employee.getEmpid());
		System.out.println("Employe Name "+employee.getEmpName());
		System.out.println("Employe Salary "+employee.getEmpSalary());
		System.out.println("Employe Department "+employee.getIdepartment().departmentType());
		
		//System.out.println("-------------------------------------------");
		//employee = applicationContext.getBean("employee1", Employee.class);
		//System.out.println("Employe Id "+employee.getEmpid());
		//System.out.println("Employe Name "+employee.getEmpName());
		//System.out.println("Employe Salary "+employee.getEmpSalary());
		//System.out.println("Employe Department "+employee.getIdepartment().departmentType());
		
		
		//System.out.println("-------------------------------------------");
		//employee = applicationContext.getBean("employee2", Employee.class);
		//System.out.println("Employe Id "+employee.getEmpid());
		//System.out.println("Employe Name "+employee.getEmpName());
		//System.out.println("Employe Salary "+employee.getEmpSalary());
		//System.out.println("Employe Department "+employee.getIdepartment().departmentType());
		
	}

}
