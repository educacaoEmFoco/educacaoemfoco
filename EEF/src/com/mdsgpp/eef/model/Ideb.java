/**************************************************************************
 * File: Ideb.java
 *
 * Purpose: Inform the Basic Education Development Index of selected state.
 **************************************************************************/

package com.mdsgpp.eef.model;

public class Ideb {

	private double elementarySchool;
	private double highSchool;
	private double earlyGrades;
	private State state;
	private int year;
	
	public Ideb() {
	}
	
	public Ideb(double elementarySchool, double highSchool, double iniciais) {
		this.elementarySchool = elementarySchool;
		this.highSchool = highSchool;
		this.earlyGrades = iniciais;
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

	public double getEarlyGrades() {
		return earlyGrades;
	}

	public void setEarlyGrades(double earlyGrades) {
		this.earlyGrades = earlyGrades;
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