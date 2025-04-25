package edu.pitt.cs;

import static org.junit.Assert.*;
import org.mockito.*;

import org.junit.Test;

public class DeathStarTest {

	/**
	 * Write an integration test for shoot.
	 * 
	 * <pre>
	 * Preconditions: A new DeathStar deathStar is created
	 *                A new Planet planet is created with hit points 10
	 * Execution Steps: Call deathStar.shoot(planet)
	 * PostConditions: Return value of call is "Wimpy planet was hit by the superlaser!"
	 *                 Planet receives a damage of 100 hit points
	 * </pre>
	 */

	DeathStar deathStar;
	Planet planet;

	@Test
	public void testShootPlanetIntegration() {
		// TODO: Fill in!
		planet = new Planet(10); 
		deathStar = new DeathStar();

		String result = deathStar.shoot(planet);

		assertEquals("Wimpy planet was hit by the superlaser!", result);
		assertEquals(-90, planet.getHitPoints()); //make sure it is 100 points damage so 10-100 = -90

		//integration tests should be on the real objects
	}

	/**
	 * Write an unit test for shoot.
	 * 
	 * <pre>
	 * Preconditions: A new DeathStar deathStar is created
	 *                A new Planet planet is created with hit points 10
	 * Execution Steps: Call deathStar.shoot(planet)
	 * PostConditions: Return value of call is "Wimpy planet was hit by the superlaser!"
	 *                 Planet receives a damage of 100 hit points
	 * </pre>
	 */
	@Test
	public void testShootPlanetUnit() {
		// TODO: Fill in!
		//mock the planet since deathStar is what is calling it and planet is the dependency
		//we want to test the real implementation of deathStar and not have planet confusing it
		deathStar = new DeathStar();
		Planet p = Mockito.mock(Planet.class);

		//define mock behavior
		Mockito.when(p.toString()).thenReturn("Wimpy planet"); // mocking toString() to return expected string
		Mockito.when(p.getHitPoints()).thenReturn(10); // mocking hit points method, planet created with 10 hit points
		Mockito.doNothing().when(p).damage(100); // mocking void method

		//call the shoot
		String result = deathStar.shoot(p);

		//verify interactions
		Mockito.verify(p).damage(100);
		assertEquals("Wimpy planet was hit by the superlaser!", result);
	}
}
