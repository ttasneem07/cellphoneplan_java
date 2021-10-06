package test;

import src.CellPhonePlan;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test CellPhonePlan methods
 * 
 * @author Tasfia Tasneem
 */

public class CellPhonePlanTest {

    /**
     * testIsValidDateJanuaryValid(): Tests valid when date is January 20 (1,20)
     */
    @Test
    public void testIsValidDateJanuaryValid() {

        assertTrue(CellPhonePlan.isValidDate(1, 20), "CellPhonePlan.isValidDate(1, 20)");

    }

    /**
     * testIsValidDateFebruaryInvalid() Tests invalid when date input is February 0
     * (2,0)
     */
    @Test
    public void testIsValidDateFebruaryInvalid() {

        assertFalse(CellPhonePlan.isValidDate(2, 0), "CellPhonePlan.isValidDate(2, 0)");

    }

    /**
     * testIsValidDateFebruaryValid() Tests valid when date is February 28 (2,28)
     */
    @Test
    public void testIsValidDateFebruaryValid() {

        assertTrue(CellPhonePlan.isValidDate(2, 28), "CellPhonePlan.isValidDate(2, 28)");

    }

    /**
     * testIsValidDateMarchValid() Tests valid when date is March 5 (3,5)
     */
    @Test
    public void testIsValidDateMarchValid() {

        assertTrue(CellPhonePlan.isValidDate(3, 5), "CellPhonePlan.isValidDate(3, 5)");

    }

    /**
     * testIsValidDateDecember() false (invalid) when date input is December 4
     * (12,4)
     */
    @Test
    public void testIsValidDateDecember() {

        assertFalse(CellPhonePlan.isValidDate(12, 4), "CellPhonePlan.isValidDate(12, 4)");

    }

    /**
     * testIsValidDateInvalidNearStartingBoundary() Tests invalid when date is
     * January 9 (Day before plan begins) (1,9)
     */
    @Test
    public void testIsValidDateInvalidNearStartingBoundary() {

        assertFalse(CellPhonePlan.isValidDate(1, 9), "CellPhonePlan.isValidDate(1, 9)");

    }

    /**
     * testIsValidDateValidAtStartingBoundary() Tests true for January 10 (Day the
     * plan begins) (1,10)
     */
    @Test
    public void testIsValidDateValidAtStartingBoundary() {

        assertTrue(CellPhonePlan.isValidDate(1, 10), "CellPhonePlan.isValidDate(1, 10)");

    }

    /**
     * testIsValidDateInvalidNearEndingBoundary() Tests inavlid for March 12 (Day
     * after plan) (3,12)
     */
    @Test
    public void testIsValidDateInvalidNearEndingBoundary() {

        assertFalse(CellPhonePlan.isValidDate(3, 12), "CellPhonePlan.isValidDate(3,12)");

    }

    /**
     * testIsValidDateValidAtEndingBoundary() Tests true for March 11 (End date of
     * plan) (3, 11)
     */
    @Test
    public void testIsValidDateValidAtEndingBoundary() {

        assertTrue(CellPhonePlan.isValidDate(3, 11), "CellPhonePlan.isValidDate(3,11)");

    }

    /**
     * testIsValidDateFebruaryInvalidDayNegative() Tests Invalid for February -5
     * (Negative day) (2, -5)
     */
    @Test
    public void testIsValidDateFebruaryInvalidDayNegative() {

        assertFalse(CellPhonePlan.isValidDate(2, -5), "CellPhonePlan.isValidDate(2,-5)");

    }

    /**
     * testIsValidDateFebruaryInvalidDayTooLarge()
     * 
     * Tests false for February 30 (2,30)
     */
    @Test
    public void testIsValidDateFebruaryInvalidDayTooLarge() {

        assertFalse(CellPhonePlan.isValidDate(2, 30), "CellPhonePlan.isValidDate(2,30)");

    }

    /**
     * testIsValidDateApril15() Tests False for April 15
     */
    @Test
    public void testIsValidDateApril15() {

        assertFalse(CellPhonePlan.isValidDate(4, 15), "CellPhonePlan.isValidDate(4, 15)");

    }

    /**
     * testIsValidPlan4() Tests True for "4" being a valid input for a plan
     */
    @Test
    public void testIsValidPlan4() {

        assertTrue(CellPhonePlan.isValidPlan("4"), "CellPhonePlan.isValidPlan(\"4\")");
    }

    /**
     * testIsValidPlanUnlimited() Tests Fasle for "Unlimited" being a valid input
     * for a plan
     */
    @Test
    public void testIsValidPlanUnlimited() {

        assertFalse(CellPhonePlan.isValidPlan("Unlimited"), "CellPhonePlan.isValidPlan(\"Unlimited\")");
    }

    /**
     * testIsValidPlan10() Tests True for "10" being a valid input for a plan
     */
    @Test
    public void testIsValidPlan10() {

        assertTrue(CellPhonePlan.isValidPlan("10"), "CellPhonePlan.isValidPlan(\"10\")");

    }

    /**
     * testIsValidPlan15() Tests true for when 15GB is entered as "15"
     */
    @Test
    public void testIsValidPlan15() {

        assertTrue(CellPhonePlan.isValidPlan("15"), "CellPhonePlan.isValidPlan(\"15\")");

    }

    /**
     * testIsValidPlanU() Test true for input "U"
     */
    @Test
    public void testIsValidPlanU() {

        assertTrue(CellPhonePlan.isValidPlan("U"), "CellPhonePlan.isValidPlan(\"U\")");

    }

    /**
     * testIsValidPlan5() Tests False for input "5" as a data plan
     */
    @Test
    public void testIsValidPlan5() {

        assertFalse(CellPhonePlan.isValidPlan("5"), "CellPhonePlan.isValidPlan(\"5\")");

    }

    /**
     * testGetPlanCostIndividual4GB() Equals $45 for and individual 4GB plan
     */
    @Test
    public void testGetPlanCostIndividual4GB() {

        assertEquals(45, CellPhonePlan.getPlanCost(1, "4"), "CellPhonePlan.getPlanCost(1, \"4\")");

    }

    /**
     * testGetPlanCost4GBGroupOf3() equals $45 3 students and 4GB plan
     */
    @Test
    public void testGetPlanCost4GBGroupOf3() {

        assertEquals(45, CellPhonePlan.getPlanCost(3, "4"), "CellPhonePlan.getPlanCost(3, \"4\")");

    }

    /**
     * testGetPlanCostGroupOfTwoUnlimitedGB() Equals $150 Individual Unlimited Plan
     */
    @Test
    public void testGetPlanCostGroupOfTwoUnlimitedGB() {

        assertEquals(150, CellPhonePlan.getPlanCost(2, "u"), "CellPhonePlan.getPlanCost(2, \"u\")");

    }

    /**
     * testGetPlanCostIndividual10GB() Equals $60 Individual 10GB plan
     */
    @Test
    public void testGetPlanCostIndividual10GB() {

        assertEquals(60, CellPhonePlan.getPlanCost(1, "10"), "CellPhonePlan.getPlanCost(1, \"10\")");

    }

    /**
     * testGetPlanCostIndividual15GB() Equals $75 Individual 15GB plan
     */
    @Test
    public void testGetPlanCostIndividual15GB() {

        assertEquals(75, CellPhonePlan.getPlanCost(1, "15"), "CellPhonePlan.getPlanCost(1, \"15\")");

    }

    /**
     * testGetPlanCostIndividualUGB() Equals $90 Individual Unlimited ("U") plan
     */
    @Test
    public void testGetPlanCostIndividualUGB() {

        assertEquals(90, CellPhonePlan.getPlanCost(1, "U"), "CellPhonePlanTest.getPlanCost(1, \"U\")");

    }

    /**
     * testGetPlanCostGroupOfTwo4GB() Equals $60 2 person 4GB plan
     */
    @Test
    public void testGetPlanCostGroupOfTwo4GB() {

        assertEquals(60, CellPhonePlan.getPlanCost(2, "4"), "CellPhonePlan.getPlanCost(2, \"4\")");

    }

    /**
     * testGetPlanCostGroupOfThree10GB() Equals $90 3 person 10GB plan
     */
    @Test
    public void testGetPlanCostGroupOfThree10GB() {

        assertEquals(90, CellPhonePlan.getPlanCost(3, "10"), "CellPhonePlan.getPlanCost(3, \"10\")");

    }

    /**
     * testGetPlanCostGroupOfTwo15GB() Equals $120 2 person 15GB plan
     */
    @Test
    public void testGetPlanCostGroupOfTwo15GB() {

        assertEquals(120, CellPhonePlan.getPlanCost(2, "15"), "CellPhonePlan.getPlanCost(2, \"15\")");

    }

    /**
     * testGetPlanCostGroupOfThreeUnlimitedGB() Equals $180 3 person Unlimited plan
     */
    @Test
    public void testGetPlanCostGroupOfThreeUnlimitedGB() {

        assertEquals(180, CellPhonePlan.getPlanCost(3, "U"), "CellPhonePlan.getPlanCost(3, \"U\")");

    }

    /**
     * testGetEndDateJanuary10() Start Date: 1/10/22 (1, 10) End Date: 4/9/22
     */
    @Test
    public void testGetEndDateJanuary10() {
        assertEquals("4/9/22", CellPhonePlan.getEndDate(1, 10), "CellPhonePlan.getEndDate(1, 10)");

    }

    /**
     * testGetEndDateMarch1() Start Date: 3/1/22 End Date: 5/29/22
     */
    @Test
    public void testGetEndDateMarch1() {
        assertEquals("5/29/22", CellPhonePlan.getEndDate(3, 1), "CellPhonePlan.getEndDate(3, 1)");

    }

    /**
     * testGetEndDateMarch11() Start Date: 3/11/22 End Date: 6/8/2
     */
    @Test
    public void testGetEndDateMarch11() {

        assertEquals("6/8/22", CellPhonePlan.getEndDate(3, 11), "CellPhonePlan.getEndDate(3, 11)");

    }

    /**
     * testGetEndDateFebruary1() Start Date: 2/1/22 End Date: 5/1/22
     */
    @Test
    public void testGetEndDateFebruary1() {

        assertEquals("5/1/22", CellPhonePlan.getEndDate(2, 1), "CellPhonePlan.getEndDate(2, 1");

    }

    /**
     * Test the CellPhonePlan methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below -
        // You do NOT
        // need to add additional invalid tests.
        // Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class, () -> CellPhonePlan.getPlanCost(0, "10"),
                "CellPhonePlan.getPlanCost(0, \"10\")");
        assertEquals("Invalid number", exception.getMessage(),
                "Testing CellPhonePlan.getPlanCost(0, \"10\") - " + "exception message");
        exception = assertThrows(IllegalArgumentException.class, () -> CellPhonePlan.getPlanCost(2, "12"),
                "CellPhonePlan.getPlanCost(2, \"12\")");
        assertEquals("Invalid plan", exception.getMessage(),
                "Testing CellPhonePlan.getPlanCost(2, \"12\") - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> CellPhonePlan.getEndDate(2, 29),
                "CellPhonePlan.getEndDate(2, 29)");
        assertEquals("Invalid date", exception.getMessage(),
                "Testing CellPhonePlan.getEndDate(2, 29) - exception message");
    }
}
