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
@Table(name = "employee104")
@Inheritance(strategy = InheritanceType.JOINED)

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

//setters and getters  
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

	// getters and setters

}
