package com.mdsgpp.eef.model;

public class Censo {

	private double earlyElementarySchoolYears;
	private double finalElementarySchoolYears;
	private double highSchool;
	private double EJAElementarySchool;
	private double EJAHighSchool;
	private int year;
	private State state;
	
	public Censo() {
	}

	public Censo(double earlyElementarySchoolYears, double finalElementarySchoolYears, double highSchool, 
		double EJAElementarySchool, double EJAHighSchool) {

		this.earlyElementarySchoolYears = earlyElementarySchoolYears;
		this.finalElementarySchoolYears = finalElementarySchoolYears;
		this.highSchool = highSchool;
		this.EJAElementarySchool = EJAElementarySchool;
		this.EJAHighSchool = EJAHighSchool;
	}

	public double getElementarySchoolEarlyYears() {
		return earlyElementarySchoolYears;
	}

	public void setEarlyElementarySchoolYears(double earlyElementarySchoolYears) {
		this.earlyElementarySchoolYears = earlyElementarySchoolYears;
	}

	public double getElementarySchoolFinalYears() {
		return finalElementarySchoolYears;
	}

	public void setFinalElementarySchoolYears(double finalElementarySchoolYears) {
		this.finalElementarySchoolYears = finalElementarySchoolYears;
	}

	public double getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(double highSchool) {
		this.highSchool = highSchool;
	}

	public double getEJAElementarySchool() {
		return EJAElementarySchool;
	}

	public void setEJAElementarySchool(double EJAElementarySchool) {
		this.EJAElementarySchool = EJAElementarySchool;
	}

	public double getEJAHighSchool() {
		return EJAHighSchool;
	}

	public void setEJAHighSchool(double EJAHighSchool) {
		this.EJAHighSchool = EJAHighSchool;
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
