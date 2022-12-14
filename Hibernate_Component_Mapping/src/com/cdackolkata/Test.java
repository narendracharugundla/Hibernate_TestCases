package com.cdackolkata;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
public static void main(String[] args) {
	Session s=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	Transaction t=s.beginTransaction();
	
	
	Employee e1=new Employee("amit",new EmployeeAddress("gzb","india",221233));
	Employee e2=new Employee("Vijay",new EmployeeAddress("noida","india",224123));
	
	s.save(e1);
	s.save(e2);
	
	t.commit();
	
	if(t.isActive()) {
		s.close();
	}
	
	System.out.println("success...");
}
}
