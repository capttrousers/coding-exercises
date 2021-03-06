import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for the Buildings Catching Water problem.
 *
 * Test Case #1
 * 5 |
 * 4 |    __                __
 * 3 |   |  |__          __|  |
 * 2 |   |  |  |__    __|  |  |
 * 1 |   |  |  |  |  |  |  |  |
 * ===================================================================
 * input: [3, 2, 1, 0, 1, 2, 3]
 * catch: [0, 1, 2, 3, 2, 1, 0]
 * total: 9
 *
 * Test Case #2
 * 5 |
 * 4 |
 * 3 |
 * 2 |    __ __ __ __ __
 * 1 |   |  |  |  |  |  |
 * ===================================================================
 * input: [1, 1, 1, 1, 1]
 * catch: [0, 0, 0, 0, 0]
 * total: 0
 *
 * Test Case #3
 * 5 |                   __
 * 4 |    __            |  |
 * 3 |   |  |   __    __|  |
 * 2 |   |  |__|  |__|  |  |__
 * 1 |   |  |  |  |  |  |  |  |
 * ===================================================================
 * input: [3, 1, 2, 1, 2, 4, 1]
 * catch: [0, 2, 1, 2, 1, 0, 0]
 * total: 6
 *
 * Test Case #4
 * 5 |             __
 * 4 |          __|  |__
 * 3 |       __|  |  |  |__
 * 2 |    __|  |  |  |  |  |__
 * 1 |   |  |  |  |  |  |  |  |
 * ===================================================================
 * input: [1, 2, 3, 4, 3, 2, 1]
 * catch: [0, 0, 0, 0, 0, 0, 0]
 * total: 0
 *
 * Test Case #5
 *                                   __
 * 5 |                   __         |  |
 * 4 |    __            |  |      __|  |
 * 3 |   |  |   __    __|  |   __|  |  |
 * 2 |   |  |__|  |__|  |  |__|  |  |  |
 * 1 |   |  |  |  |  |  |  |  |  |  |  |
 * ===================================================================
 * input: [3, 1, 2, 1, 2, 4, 1, 2, 3, 5]
 * catch: [0, 2, 1, 2, 1, 0, 3, 2, 1, 0]
 * total: 12
 *
 */
public class BuildingsCatchingWaterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testCase1() {
        int[] buildings = new int[]{3, 2, 1, 0, 1, 2, 3};
        int   expectedWaterCaught = 9;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }

    @Test
    public void testCase2() {
        int[] buildings = new int[]{1, 1, 1, 1, 1};
        int   expectedWaterCaught = 0;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }

    @Test
    public void testCase3() {
        int[] buildings = new int[]{3, 1, 2, 1, 2, 4, 1};
        int   expectedWaterCaught = 6;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }

    @Test
    public void testCase4() {
        int[] buildings = new int[]{1, 2, 3, 4, 3, 2, 1};
        int   expectedWaterCaught = 0;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }

    @Test
    public void testCase5() {
        int[] buildings = new int[]{3, 1, 2, 1, 2, 4, 1, 2, 3, 5};
        int   expectedWaterCaught = 12;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }

    @Test
    public void testCaseNullArray() {
        thrown.expect(IllegalArgumentException.class);
        int[] buildings = null;
        BuildingsCatchingWater.compute(buildings);
        thrown.expectMessage("invalid inputs to compute(), null buildings");
    }

    @Test
    public void testCaseEmptyArray() {
        int[] buildings = {};
        int   expectedWaterCaught = 0;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }

    @Test
    public void testCaseOneBuilding() {
        int[] buildings = new int[]{1};
        int   expectedWaterCaught = 0;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }

    @Test
    public void testCaseTwoBuildings() {
        int[] buildings = new int[]{3, 1};
        int   expectedWaterCaught = 0;
        Assert.assertEquals(expectedWaterCaught, BuildingsCatchingWater.compute(buildings));
    }
}
