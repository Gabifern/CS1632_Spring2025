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
		//mock the planet since deathStar is what is calling it
		planet = new Planet(10);
		deathStar = new DeathStar();

		deathStar.shoot(planet);


	}
}
