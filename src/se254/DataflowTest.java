package se254;
import junit.framework.TestCase;
import se254.dates.Dates;

/** 
 * Tests the du path of the int days2dd in the case that the day being investigated is a doomsday itself.
 * This test ensures that the correct output is given when days2dd is defined as 0 in line 91, and then used in line 102.
 * days2dd is defined in line 94, but to 0, the same value it had before that line.
 * In all the tests in BranchTests, days2dd is redefined in lines 94 and/or 97. 
 * Therefore, this is a case that is not covered in BranchTests, and will increase the probability of finding a fault.
 */
public class DataflowTest extends TestCase {
	public void testDataFlow() {
		assertEquals("Thursday", Dates.dayOfWeek(2013, 4, 4).toString());
	}
}
