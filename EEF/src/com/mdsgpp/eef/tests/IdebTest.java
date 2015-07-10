package com.mdsgpp.eef.tests;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.model.State;
import com.mdsgpp.eef.model.Ideb;

public class IdebTest extends AndroidTestCase {

	private Ideb ideb;
	private State state;
	private double earlyGrades, elementarySchool, highSchool;
	private int year;
	
	public void setUp() throws Exception {
		this.ideb = new Ideb();
		this.state = new State();
		
		this.earlyGrades = 1.5;
		this.elementarySchool = 2.3;
		this.highSchool = 1.9;
		this.year = 1990;
	}
	
	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testEarlyGrades() {
		double currentEarlyGrades;
		
		this.ideb.setEarlyGrades(this.earlyGrades);
		currentEarlyGrades = this.ideb.getEarlyGrades();
		
		assertEquals(this.earlyGrades, currentEarlyGrades, 0.0);
	}

	public void testElementarySchool() {
		double currentElementarySchool;
		
		this.ideb.setElementarySchool(this.elementarySchool);
		currentElementarySchool = this.ideb.getElementarySchool();
		
		assertEquals(this.elementarySchool, currentElementarySchool, 0.0);
	}
	
	public void testHighSchool() {
		double currentHighSchool;
		
		this.ideb.setHighSchool(this.highSchool);
		currentHighSchool = this.ideb.getHighSchool();
		
		assertEquals(this.highSchool, currentHighSchool, 0.0);
	}
	
	public void testState() {
		State currentState;
		
		this.ideb.setState(state);
		currentState = this.ideb.getState();
		
		assertEquals(this.state, currentState);
	}
	
	public void testAno() {
		int currentYear;
		
		this.ideb.setYear(this.year);
		currentYear = this.ideb.getYear();
		
		assertEquals(this.year, currentYear);
	}
}
