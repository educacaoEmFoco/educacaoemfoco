package com.mdsgpp.eef.model;

public class Average {

	private double elementarySchool;
	private double highSchool;
	private int year;
	private State state;
		
	public Average() {
	}
		
	public Average(double elementarySchool, double highSchool) {
		this.elementarySchool = elementarySchool;
		this.highSchool = highSchool;
	}
		
	public double getElementarySchool() {
		return elementarySchool;
	}

	public void setElementarySchool(double elementarySchool) {
		this.elementarySchool = elementarySchool;
	}

	public double getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(double highSchool) {
		this.highSchool = highSchool;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}		
}