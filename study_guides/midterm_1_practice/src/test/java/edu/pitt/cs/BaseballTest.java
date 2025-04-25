package edu.pitt.cs;

import static org.junit.Assert.*;
import org.mockito.*;

import org.junit.Test;

public class BaseballTest {
    /**
 * <pre>
 * Preconditions: A Pitcher pitcher is created.
 * Execution steps: Call pitcher.addStress(10).
 * Postconditions: pitcher.getStress() returns 10.
 * </pre>
 */
@Test
public void testAddStress() {
	// TODO: Fill in
    //pre
    Pitcher pitcher = new Pitcher();

    //exe
    pitcher.addStress(10);

    //post
    int stress = pitcher.getStress();
    assertEquals(10, stress);
}

/**
 * <pre>
 * Preconditions: A Pitcher pitcher is created.
 *                The pitcher always throws strikes.
 *                A Batter batter is created.
 *                The batter always swings bat.
 *                A BallGame game is created using pitcher and batter.
 * Execution steps: Call game.pitch().
 * Postconditions: The string "hit" is returned from the call.
 *                 Stress of 10 is added to the pitcher.
 * </pre>
 */
@Test
public void testPitch() {
	// TODO: Fill in

    //pre
    Pitcher pitcher = Mockito.mock(Pitcher.class);
    Batter batter = Mockito.mock(Batter.class);
    //create ball game
    BallGame game = new BallGame(pitcher, batter);
    
    Mockito.when(batter.swingBat()).thenReturn(true); //the bat is always swung
    Mockito.when(pitcher.throwBall()).thenReturn(true); //strike is thrown
    Mockito.when(pitcher.getStress()).thenReturn(10); //add 10 stress points

    //exe
    String result = game.pitch();

    //post
    assertEquals("hit", result);
    assertEquals(10, pitcher.getStress());
}

}
