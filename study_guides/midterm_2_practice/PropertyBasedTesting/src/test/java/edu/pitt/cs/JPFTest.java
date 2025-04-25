package edu.pitt.cs;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JPFTest extends TestJPF {
	private static int x;
	private static int y;

	public static void setUp() {
		// TODO: Fill in. Test all x, y where -10 <= x <= 10 and -10 <= y <= 10.
		x = Verify.getInt(-10, 10);
		y = Verify.getInt(-10, 10);
	}

	@Test
	public void testSquare() {
		/*
		 * When host JVM encounters the verifyNoPropertyViolation(), it invokes the JPF
		 * VM on this test method. So there are effectively two virtual machines
		 * executing this method. The verifyNoPropertyViolation() method returns false
		 * if the executing VM is the host JVM and returns true if it is the JPF VM.
		 */
		if (verifyNoPropertyViolation() == false) {
			// This is the host JVM so return immediately.
			return;
		}
		// This is the JPF VM, so run the test case on top of it, starting from the setUp().
		setUp();

		int ret = IntegerOps.square(x);
		// TODO: Fill in.

		//invariants
		// square(x) >= 0
		// square(x) = x*x
		// square(x) == square(-x)

		assertThat(ret, greaterThanOrEqualTo(0));
		assertEquals(x * x, ret);
		assertEquals(IntegerOps.square(-x), ret);
	}

	@Test
	public void testAdd() {
		/*
		 * When host JVM encounters the verifyNoPropertyViolation(), it invokes the JPF
		 * VM on this test method. So there are effectively two virtual machines
		 * executing this method. The verifyNoPropertyViolation() method returns false
		 * if the executing VM is the host JVM and returns true if it is the JPF VM.
		 */
		if (verifyNoPropertyViolation() == false) {
			// This is the host JVM so return immediately.
			return;
		}
		// This is the JPF VM, so run the test case on top of it, starting from the setUp().
		setUp();

		int ret = IntegerOps.add(x, y);
		// TODO: Fill in.

		// Invariants:
		// 1. add(x, y) == x + y
		// 2. add(x, y) == add(y, x)
		assertEquals(x + y, ret);
		assertEquals(IntegerOps.add(y, x), ret);
	}

}