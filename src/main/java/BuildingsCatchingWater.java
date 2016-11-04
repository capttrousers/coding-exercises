import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers (that represents buildings in sequential order), compute how much rain water
 * they would catch. The amount of water 'caught' for a given building can be computed by checking the
 * bounding buildings on either side.
 */
public class BuildingsCatchingWater {


    public static int compute(int[] buildings) throws IllegalArgumentException {
        if(buildings == null) {
            throw new IllegalArgumentException("invalid input array of buildings");
        }
        int len = buildings.length;
        if(len < 3) {
            return 0;
        }
        int total = 0;

        int[] maxBuildingHeight = new int[len];
        int maxLeft = 0;
        // this could be optimized by putting both maxLeft and maxRight in the same loop and handle the index i
        for (int i = 0; i < len; i++) {
            maxBuildingHeight[i] = maxLeft;
            if(buildings[i] > maxBuildingHeight[i]) {
                maxLeft = buildings[i];
                maxBuildingHeight[i] = maxLeft;
            }
        }
        int maxRight = 0;
        for (int i = len - 1; i >= 0; i--) {
            if(maxRight < maxBuildingHeight[i]) {
                maxBuildingHeight[i] = maxRight;
            }
            if(buildings[i] > maxBuildingHeight[i]) {
                maxRight = buildings[i];
                maxBuildingHeight[i] = maxRight;
            }
        }
        for(int i = 0; i < len; i++) {
            total += maxBuildingHeight[i] - buildings[i];
        }
        return total;
    }

}
