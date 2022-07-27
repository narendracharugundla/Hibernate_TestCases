package com.cdackolkata.mypackage;  
  
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;  
import jakarta.persistence.Table;
import jakarta.persistence.Transient;  
  
@Entity  
@Table(name= "emp426")   
public class Employee {    
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private int id; 
@Column(name = "first_name")
private String firstName;
@Column(name = "last_name")
private String lastName; 
//@Transient
private Integer age;
    
public int getId() {    
    return id;    
}    
public void setId(int id) {    
    this.id = id;    
}    
public String getFirstName() {    
    return firstName;    
}    
public void setFirstName(String firstName) {    
    this.firstName = firstName;    
}    
public String getLastName() {    
    return lastName;    
}    
public void setLastName(String lastName) {    
    this.lastName = lastName;    
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}    


}   