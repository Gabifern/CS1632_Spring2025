package edu.pitt.cs;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest {
	@Test
	public void testStop() {
		int lineLength = 5;
		Bus bus = new Bus();
		bus.stop(lineLength);
		int p = bus.getPassengerNum();

		// TODO: Invariant assertion for lower and upper bounds of p.

		// TODO: Invariant assertion for relationship between p and lineLength.

	}
	
	@Test
	public void testTrip() {
		Bus bus = new Bus();
		bus.trip();
		int p = bus.getPassengerNum();
		int m = bus.getMoney();

		// TODO: Invariant assertion for lower and upper bounds of p.

		// TODO: Invariant assertion for lower and upper bounds of m.

		// TODO: Invariant assertion for relationship between p and m.

	}
}
