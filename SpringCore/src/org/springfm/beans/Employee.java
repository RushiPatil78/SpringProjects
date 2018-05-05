package org.springfm.beans;

public class Employee {
	private int empid;
	private String empName;
	private int empSalary;
	private IDepartment idepartment;

	public Employee(int empid, String empName, int empSalary, IDepartment idepartment) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empSalary = empSalary;
		this.idepartment = idepartment;
	}

	public IDepartment getIdepartment() {
		return idepartment;
	}

	public void setIdepartment(IDepartment idepartment) {
		this.idepartment = idepartment;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
}
