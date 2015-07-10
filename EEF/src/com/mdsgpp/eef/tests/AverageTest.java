package com.mdsgpp.eef.tests;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.model.State;
import com.mdsgpp.eef.model.Average;

public class AverageTest extends AndroidTestCase {

	private Average average;
	private State state;
	private double elementarySchool, highSchool;
	private int year;
	
	public void setUp() throws Exception {
		this.average = new Average();
		this.state = new State();
		
		this.elementarySchool = 450.00;
		this.highSchool = 90.90;
		this.year = 2006;
	}
	
	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testFinalYears() {
		double currentFinalYears;
		
		this.average.setElementarySchool(this.elementarySchool);
		currentFinalYears = this.average.getElementarySchool();
		
		assertEquals(this.elementarySchool, currentFinalYears, 0.0);
	}
	
	public void testHighSchoolTotal() {
		double currentHighSchoolTotal;
		
		this.average.setHighSchool(this.highSchool);
		currentHighSchoolTotal = this.average.getHighSchool();
		
		assertEquals(this.highSchool, currentHighSchoolTotal, 0.0);
	}
	
	public void testState() {
		State currentState;
		
		this.average.setState(this.state);
		currentState = this.average.getState();
		
		assertEquals(this.state, currentState);
	}
	
	public void testYear() {
		int currentYear;
		
		this.average.setYear(this.year);
		currentYear = this.average.getYear();
		
		assertEquals(this.year, currentYear);
	}
}
