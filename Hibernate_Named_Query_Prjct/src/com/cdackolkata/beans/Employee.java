/**
 * 
 */
package com.cdackolkata.beans;

/**
 * @author a807228
 *
 */
import jakarta.persistence.*;  
import jakarta.persistence.Entity;  
import jakarta.persistence.GeneratedValue;  
import jakarta.persistence.Id;  
  
@NamedQueries(  
    {  
        @NamedQuery(  
        name = "findEmployeeByName",  
        query = "from Employee e where e.name = :name"  
        ) ,
        @NamedQuery(  
    	        name = "findEmployeeByName",  
    	        query = "from Employee e where e.name = :name"  
    	   ) ,	
        
        @NamedQuery(  
    	        name = "findEmployeeBySalary",  
    	        query = "from Employee e where e.name = :name"  
    	   )
    } 
    
)  
  
@Entity  
@Table(name="em")  
public class Employee {  
      
    public String toString(){return id+" "+name+" "+salary+" "+job;}  
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    int id;  
    String name;  
    int salary;  
    String job;
    //getters and setters  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}  
    
       
  
}  
