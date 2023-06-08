package com.cg.oeca.dto;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Table annotation allows you to specify the details of the table that will be used to persist 
* the entity in the database*/
@Table(name="admin_tbl")
@Component
public class Admin implements Serializable{
	@Id//correspond to the primary key of the object's table
	//@GeneratedValue(strategy=GenerationType.AUTO)//automatically generates the primary key value
	//@Column Specifies the mapped column for a persistent property
	@Column(name="AdminId",nullable=false)
	private int adminId;
	@Column(name="AdminUsername",nullable=false)
	private String adminUsername;
	@Column(name="AdminPassword",nullable=false)
	private String adminPassword;
	//Constructor
	public Admin() {
		super();
	}
	//Parameterized constructor
	public Admin(int adminId, String adminUsername, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	//getters and setters
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ "]";
	}	
}
