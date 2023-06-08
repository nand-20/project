package com.cg.oeca.dto;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Table annotation allows you to specify the details of the table that will be used to persist 
* the entity in the database*/
@Table(name="spectacles")
public class Spectacles implements Serializable{
	@Id//correspond to the primary key of the object's table
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column Specifies the mapped column for a persistent property
	@Column(name="SpectaclesId",nullable=false)
	private int spectaclesId;
	@Column(name="SpectaclesNumber",nullable=false)
	private String spectaclesNumber;
	@Column(name="SpectaclesModel",nullable=false)
	private String spectaclesModel;
	@Column(name="SpectaclesDescription",nullable=false)
	private String spectaclesDescription;
	@Column(name="SpectaclesCost",nullable=false)
	private double spectaclesCost;
	//Constructor
	public Spectacles() {
		super();
	}
	//Parameterized constructor
	public Spectacles(int spectaclesId, String spectaclesNumber, String spectaclesModel, String spectaclesDescription,
			double spectaclesCost) {
		super();
		this.spectaclesId = spectaclesId;
		this.spectaclesNumber = spectaclesNumber;
		this.spectaclesModel = spectaclesModel;
		this.spectaclesDescription = spectaclesDescription;
		this.spectaclesCost = spectaclesCost;
	}
	//getters and setters
	public int getSpectaclesId() {
		return spectaclesId;
	}
	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}
	public String getSpectaclesModel() {
		return spectaclesModel;
	}
	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}
	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}
	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}
	public double getSpectaclesCost() {
		return spectaclesCost;
	}
	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
	
	public String getSpectaclesNumber() {
		return spectaclesNumber;
	}
	public void setSpectaclesNumber(String spectaclesNumber) {
		this.spectaclesNumber = spectaclesNumber;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Spectacles [spectaclesId=" + spectaclesId + ", spectaclesModel=" + spectaclesModel
				+ ", spectaclesDescription=" + spectaclesDescription + ", spectaclesCost=" + spectaclesCost + "]";
	}
	
}
