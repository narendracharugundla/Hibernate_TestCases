/**
 * 
 */
package com.cdackolkata.mypackage;

/**
 * @author a807228
 *
 */
import jakarta.persistence.*;  

@Entity  
@Table(name="regularemployee104")  
@PrimaryKeyJoinColumn(name="ID")  
public class Regular_Employee extends Employee{  
      
@Column(name="salary")    
private float salary;  
  
@Column(name="bonus")     
private int bonus;  
	//getters and setters 
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}  
	  
	 
	
	

}
