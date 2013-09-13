package se254;
import junit.framework.TestCase;
import se254.dates.Dates;

/** 
 * This tests the equivalence class of (day = 31, month = [Months with 30 days]). 
 * As the number of days per month is listed inside Dates, if this day is handled correctly for one of them,
 * it should be handled correctly for all of them. 
 * This is not tested in BranchTests or DataflowTest, so it will increase the chance of the test suite finding a fault.
 */
public class EquivalenceTest extends TestCase {
	public void testEquivalenceClass() {
		try {
			assertEquals("Tuesday", Dates.dayOfWeek(2013, 9, 31).toString());
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=2013, month=9, day=31", e.getMessage());
		}
	}
}
