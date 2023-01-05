package com.csi.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue
	
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_address")
	private String empAddress;
	
	@Column(name = "emp_contact_number")
	private long empContactNumber;
	
	@Column(name = "emp_salary")
	private double empSalary;
	
	@Column(name = "emp_uid", unique = true)
	private long empUId;
	
	@Column(name = "emp_dob")
	private Date empDOB;
	
	@Column(name = "emp_email_id", unique =  true)
	private String empEmailId;
	
	@Column(name = "emp_password")
	private String empPassword;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empAddress, long empContactNumber, double empSalary, long empUId,
			Date empDOB, String empEmailId, String empPassword) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empContactNumber = empContactNumber;
		this.empSalary = empSalary;
		this.empUId = empUId;
		this.empDOB = empDOB;
		this.empEmailId = empEmailId;
		this.empPassword = empPassword;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public long getEmpContactNumber() {
		return empContactNumber;
	}

	public void setEmpContactNumber(long empContactNumber) {
		this.empContactNumber = empContactNumber;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public long getEmpUId() {
		return empUId;
	}

	public void setEmpUId(long empUId) {
		this.empUId = empUId;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress
				+ ", empContactNumber=" + empContactNumber + ", empSalary=" + empSalary + ", empUId=" + empUId
				+ ", empDOB=" + empDOB + ", empEmailId=" + empEmailId + ", empPassword=" + empPassword + "]";
	}
	

	
}
