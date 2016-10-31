import org.junit.Assert;
import org.junit.Test;

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
 */
public class BuildingsCatchingWaterTest {

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
}
