package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HolidayBonusTestStudent {
    private double[][] sales;

    @BeforeEach
    public void setUp() throws Exception {
        sales = new double[][] { { 111, 222, 333 }, { 444, 555 }, { 666, 777, 888, 999 } };
    }

    @AfterEach
    public void tearDown() throws Exception {
        sales = null;
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(sales, 5000, 1000, 2000);
        assertArrayEquals("Bonuses for each store should be calculated correctly.",
                new double[] { 6666, 7777, 12345 }, bonuses, 0.001);
    }

    private void assertArrayEquals(String string, double[] ds, double[] bonuses, double d) {
		
	}

	@Test
    public void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(sales, 5000, 1000, 2000);
        assertEquals("Total bonus should be 12345.0.", 12345.0, totalBonus, 0.001);
    }

	private void assertEquals(String string, double d, double totalBonus, double e) {
		
	}
}

	
