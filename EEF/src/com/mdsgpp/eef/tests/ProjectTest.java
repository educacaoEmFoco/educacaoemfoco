package com.mdsgpp.eef.tests;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.model.State;
import com.mdsgpp.eef.model.Project;

public class ProjectTest extends AndroidTestCase {

	private Project project;
	private State state;
	private int quantity;
	private double value;
	private int year;
	
	public void setUp() throws Exception {
		this.state = new State();
		this.project = new Project();
		this.quantity = 10;
		this.value = 10000.50;
		this.year = 1990;
	}

	public void tearDown() throws Exception {
		// Do nothing.
	}

	public void testValor() {
		double currentValue;
		
		this.project.setValue(this.value);
		currentValue = this.project.getValue();
		
		assertEquals(this.value, currentValue, 0.0);
	}
	
	public void testQuantity() {
		int currentQuantity;
		
		this.project.setQuantity(this.quantity);
		currentQuantity = this.project.getQuantity();
		
		assertEquals(this.quantity, currentQuantity);
	}
	
	public void testState() {
		State currentState;
		
		this.project.setState(this.state);
		currentState = this.project.getState();
		
		assertEquals(this.state, currentState);
	}
	public void testAno() {
		int currentYear;
		
		this.project.setYear(this.year);
		currentYear = this.project.getYear();
		
		assertEquals(this.year, currentYear);
	}
}
