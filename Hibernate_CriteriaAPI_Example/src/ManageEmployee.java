
/**
 * 
 */

/**
 * @author a807228
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cdackolkata.Employee;

public class ManageEmployee {
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageEmployee ME = new ManageEmployee();

		/* Add few employee records in database */
		Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
		Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
		Integer empID3 = ME.addEmployee("John", "Paul", 10000);

		/* List down all the employees */
		ME.listEmployees();

		/* Update employee's records */
		ME.updateEmployee(empID1, 5000);

		/* Delete an employee from the database */
		ME.deleteEmployee(empID2);

		/* List down new list of the employees */
		ME.listEmployees();
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ all the employees */
	public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         //String hql = "FROM com.cdackolkata.Employee";////Select * from Employee
         //or 
        // String hql = "FROM Employee";//Select * from Employee
        // String hql = "FROM Employee  E";
         //String hql = "SELECT E.firstName FROM Employee AS E";
        // String hql = "SELECT E.firstName FROM Employee  E WHERE E.id = 1";
         String hql = "FROM Employee";
         Query query = session.createQuery(hql);
         query.setFirstResult(1);
         query.setMaxResults(2);
         List results = query.list();
         
         //session.createSelectionQuery(Employee.class);
         
        // Crietria c=session.createCriteria(Employee.class);//passing Class class argument  
         List list=c.list();  
         
        // String hql = "SELECT E.firstName FROM Employee E WHERE E.id > 1 ORDER BY E.salary DESC";
         //List employees = session.createQuery(hql).list(); 
       
		/*
		 * for(int i=0; i<employees.size(); i++) { System.out.println(employees.get(i));
		 * 
		 * }
		 */
		
			/*
			 * for (Iterator iterator = employees.iterator(); iterator.hasNext();){ String
			 * names = (String) iterator.next(); System.out.println(names); }
			 */
		 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer EmployeeID, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			//Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			//employee.setSalary(salary);
			
			int salary1=1000;
			
			String hql = "UPDATE Employee set salary = :salary "  + 
		             "WHERE id = :employee_id";
			
		Query query = session.createQuery(hql);
		query.setParameter("salary", 200000);
		query.setParameter("employee_id", 1);
		int result = query.executeUpdate();
		tx.commit();
		query.setParameter("salary", 100000);
		query.setParameter("employee_id", 3);
		 result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
			
			
		
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}