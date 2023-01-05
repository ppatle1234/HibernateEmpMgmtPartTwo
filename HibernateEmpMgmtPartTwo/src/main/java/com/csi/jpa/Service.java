package com.csi.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		Service service = new Service();
		//service.signUp();
		
		// System.out.println(service.signIn("pras@7.com", "prashant@345"));
		
		// service.saveBulkOfData();
		
		service.getDataById(7);
		
		//service.getAllData();
		
		// service.updateData(2);
		
		// service.filterDataBySalary(40000.00);
		
		// service.deleteDataById(6);
		
		//service.deleteAllData();
	}
	
	public void signUp()
	{
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Date dobDate = null;
		
		try {
			dobDate = simpleDateFormat.parse("11-11-1999");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String employeeDOB = simpleDateFormat.format(dobDate);
		Employee employee = new Employee("Rahul", "Nashik", 9097506533l, 32000.40, 56740, dobDate, "rahul@4.com", "rah@7");
		session.save(employee);
		transaction.commit();
		
	}

	public boolean signIn(String emailId, String empPassword)
	{
		boolean flag = false;
		
		Session session = factory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		
		for(Employee employee : empList)
		{
			if(employee.getEmpEmailId().equals(emailId) && employee.getEmpPassword().equals(empPassword))
			{
				flag = true;
			}
		}
		return flag;
	}
	
	public void saveBulkOfData()
	{
        Session session = factory.openSession();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Date dobDate1 = null;
		Date dobDate2 = null;
		
		try {
			dobDate1 = simpleDateFormat.parse("10-05-1987");
			dobDate2 = simpleDateFormat.parse("04-02-2004");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String employeeDOB = simpleDateFormat.format(dobDate);
		Employee employee1 = new Employee("Sunil", "Hingoli", 7345675623l, 15000.02, 32083, dobDate1, "sunil@231.com", "sun@60");
		Employee employee2 = new Employee("Sandip", "Pune", 9054237322l, 43000.70, 27690, dobDate2, "sandip@965.com", "san@24");
	
		List<Employee> empList = new LinkedList<Employee>();
		
		empList.add(employee1);
		empList.add(employee2);
		
		for(Employee emp : empList)
		{
			Transaction transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
		}
	}
	
	public void getDataById(int empId)
	{
		Session session = factory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		empList.stream().filter(emp -> emp.getEmpId() == empId).forEach(System.out::println);
		
	}
	
	public void getAllData()
	{
		Session session = factory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		empList.forEach(System.out::println);
	}
	
	public void updateData(int empId)
	{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 
		Date dobDate = null;
		try {
		      dobDate = simpleDateFormat.parse("23-09-2001");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		for(Employee emp : empList)
		{
			if(emp.getEmpId()==empId)
			{
				emp.setEmpName("Ritesh");
				emp.setEmpAddress("Delhi");
				emp.setEmpSalary(23454.43);
				emp.setEmpDOB(dobDate);
				emp.setEmpContactNumber(34533444l);
				emp.setEmpUId(234);
				emp.setEmpPassword("rit@342");
				emp.setEmpEmailId("ritesh@csi.com");
				
				session.update(emp);
				transaction.commit();
				
			}
		}
	}
	
	public void filterDataBySalary(double empSalary)
	{
		Session session = factory.openSession();
		
		List<Employee> empList = session.createQuery("from Employee").list();
		
		empList.stream().filter(emp -> emp.getEmpSalary() >= empSalary).forEach(System.out::println);
		
		
	}
	
	public void deleteDataById(int empId)
	{
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		List<Employee> empList = session.createQuery("from Employee").list();
		
		for(Employee employee : empList)
		{
			if(employee.getEmpId() == empId)
			{
				session.delete(employee);
				transaction.commit();
			}
			
		}
	}
	
	public void deleteAllData()
	{
		Session session = factory.openSession();
		
		List<Employee> empList = session.createQuery("from Employee").list();
		
		for(Employee employee : empList)
		{
			Transaction transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
		}
	}
}
