package se254;
import junit.framework.TestCase;
import se254.dates.Dates;

/** 
 * 100% statement coverage of class Dates is impossible because EMMA includes lines such as package declaration etc. 
 * 100% branch coverage of the method Dates.dayOfWeek is also impossible because the break command used 
 * when the correct month is found means that the loop will never end naturally (Reaching the end of the array).
 * Therefore, one of branches of the implicit command in the for-each loop (i < doomsdaysByMonth.length) 
 * will never be executed as i will never be greater than doomsdaysByMonth.length
 */
public class BranchTests extends TestCase {
	
	public void testFirstValidDay() {
		assertEquals("Monday", Dates.dayOfWeek(1753, 1, 1).toString());
	}
	
	public void testLeapYear() {
		assertEquals("Saturday", Dates.dayOfWeek(2004, 5, 1).toString());
	}
	
	public void testFebruary30OnLeapYear() {
		try {
			assertEquals("Sunday", Dates.dayOfWeek(2004, 2, 30).toString());
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=2004, month=2, day=30", e.getMessage());
		}
	}
	
	public void testInvalidYear() {
		try {
			assertEquals("Saturday", Dates.dayOfWeek(1752, 12, 32).toString());
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=1752, month=12, day=32", e.getMessage());
		}
	}
	
	public void testInvalidMonth() {
		try {
			assertEquals("Saturday", Dates.dayOfWeek(2000, 0, 15).toString());
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=2000, month=0, day=15", e.getMessage());			
		}
		try {
			assertEquals("Saturday", Dates.dayOfWeek(2000, 13, 15).toString());
		} catch (IllegalArgumentException f) {
			assertEquals("Invalid date: year=2000, month=13, day=15", f.getMessage());
		}
	}
	
	public void testInvalidDay() {
		try {
			assertEquals("Saturday", Dates.dayOfWeek(2000, 1, 0).toString());
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date: year=2000, month=1, day=0", e.getMessage());
			}
		try {
			assertEquals("Saturday", Dates.dayOfWeek(2000, 1, 32).toString());
		} catch (IllegalArgumentException f) {
			assertEquals("Invalid date: year=2000, month=1, day=32", f.getMessage());
			}
	}

	public void testYearMultipleOf100() {
		assertEquals("Tuesday", Dates.dayOfWeek(2100, 6, 15).toString());
	}
	
	public void testFebruary29() {
		assertEquals("Sunday", Dates.dayOfWeek(2004, 2, 29).toString());
	}
}
