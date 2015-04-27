/******************************************************************************
 * File: Project.java
 * 
 * Purpose: Inform all projects from a state and their respective informations, 
 * like quantity, value.
 ******************************************************************************/

package com.mdsgpp.eef.model;

public class Project {

	private int quantity;
	private double value;
	private State state;
	private int year;
	
	public Project() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}	
}