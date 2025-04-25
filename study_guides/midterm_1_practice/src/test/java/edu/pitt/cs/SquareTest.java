package edu.pitt.cs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.mockito.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.sl.In;

import org.junit.Test;

public class SquareTest {

	/**
	 * Write an integration test for setSquared.
	 * 
	 * <pre>
	 * Preconditions: A new Square square is created
	 *                A new Number number is created
	 * Execution Steps: Call square.setSquared(number, 3)
	 * PostConditions: The value of number is set to 9
	 * </pre>
	 */
	Square square;
	Number number;

	@Test
	public void testSetSquaredIntegration() {
		// TODO: Fill in!
		//do not forget to instantiate the new types
		square = new Square();
		number = new Number();

		square.setSquared(number, 3);
		assertEquals(9, number.getVal()); //need to get the value (otherwise will be location)
	}

	/**
	 * Write a unit test for setSquared.
	 * 
	 * <pre>
	 * Preconditions: A new Square square is created
	 *                A new Number number is created
	 * Execution Steps: Call square.setSquared(number, 3)
	 * PostConditions: The value of number is set to 9
	 * </pre>
	 */
	@Test
	public void testSetSquaredUnit() {
		// TODO: Fill in!
		square = new Square();
		//number = new Number();
		Number num = Mockito.mock(Number.class);

		square.setSquared(num, 3);
		verify(num).setVal(9);

	} //use the mocks here by making Mockito object and verify
	//we want to test the square class so we use real but if we used real 
	//for both of them then it would be testing both number and square

	// Unit Test: In unit testing, we isolate the method or unit of code under test 
	// and verify its behavior by controlling the dependencies it interacts with. 
	// The goal is to focus on testing just that method in isolation without worrying 
	// about the inner workings or behavior of the dependencies (in this case, Number).

	// Mocking Dependencies: When testing a method that depends on other objects 
	// (like Square calling methods on Number), we mock the dependencies. 
	// In your test, Square depends on Number to perform its work (setVal). 
	// By mocking Number, we can control how it behaves and verify that Square is interacting with it correctly.
}
