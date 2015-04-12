package com.mdsgpp.eef.testes;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.model.Census;
import com.mdsgpp.eef.model.State;

public class CensusTest extends AndroidTestCase {

	private Census census;
	private State state;
	private double initialYearsElementary, finalYearsElementary, highSchool, EJAElementary, 
		EJAHighSchool;
	private int year;
	
	public void setUp() throws Exception {
		this.census = new Census();
		this.state = new State();
		
		this.initialYearsElementary = 87.11;
		this.finalYearsElementary = 880.98;
		this.highSchool = 12.23;
		this.EJAElementary = 99.90;
		this.EJAHighSchool = 460.21;
		this.year = 2005;
	}

	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testFullConstructor() {
		Census censoConstruido = new Census(this.initialYearsElementary, this.finalYearsElementary, 
			this.highSchool, this.EJAElementary, this.EJAHighSchool);
		
		assertEquals(this.initialYearsElementary, censoConstruido.getElementarySchoolEarlyYears(), 
			0.0);
		assertEquals(this.finalYearsElementary, censoConstruido.getElementarySchoolFinalYears(), 0.0);
		assertEquals(this.highSchool, censoConstruido.getHighSchool(), 0.0);
		assertEquals(this.EJAElementary, censoConstruido.getEJAElementarySchool(), 0.0);
		assertEquals(this.EJAHighSchool, censoConstruido.getEJAHighSchool(), 0.0);
	}
	
	public void testElementaryInitialYears() {
		double initialYearsElementary;
		
		this.census.setEarlyElementarySchoolYears(this.initialYearsElementary);
		initialYearsElementary = this.census.getElementarySchoolEarlyYears();
		
		assertEquals(this.initialYearsElementary, initialYearsElementary, 0.0);
	}
	
	public void testElementaryFinalYears() {
		double finalYearsElementary;
		
		this.census.setFinalElementarySchoolYears(this.finalYearsElementary);
		finalYearsElementary = this.census.getElementarySchoolFinalYears();
		
		assertEquals(this.finalYearsElementary, finalYearsElementary, 0.0);
	}
	
	public void testHighSchool() {
		double currentHighSchool;
		
		this.census.setHighSchool(this.highSchool);
		currentHighSchool = this.census.getHighSchool();
		
		assertEquals(this.highSchool, currentHighSchool, 0.0);
	}
	
	public void testEJAElementary() {
		double currentEJAElementary;
		
		this.census.setEJAElementarySchool(this.EJAElementary);
		currentEJAElementary = this.census.getEJAElementarySchool();
		
		assertEquals(this.EJAElementary, currentEJAElementary, 0.0);
	}
	
	public void testHighSchoolEJA() {
		double currentEJAHighSchool;
		
		this.census.setEJAHighSchool(this.EJAHighSchool);
		currentEJAHighSchool = this.census.getEJAHighSchool();
		
		assertEquals(this.EJAHighSchool, currentEJAHighSchool, 0.0);
	}
	
	public void testState() {
		State currentState;
		
		this.census.setState(this.state);
		currentState = this.census.getState();
		
		assertEquals(this.state, currentState);
	}
	
	public void testYear() {
		int currentYear;
		
		this.census.setYear(this.year);
		currentYear = this.census.getYear();
		
		assertEquals(this.year, currentYear);
	}
}