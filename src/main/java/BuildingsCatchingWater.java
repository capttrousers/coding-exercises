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
        if(buildings.length < 3) {
            return 0;
        }
        int[] newBuildings = trim(buildings);
        if(newBuildings.length == 0) {
            return 0;
        }
        return BCWIncremental(newBuildings);
    }

    private static int BCWRecursive(int[] buildings, int left, int right) {
        if(! (right - left > 1)) {
            return 0;
        }
        int minHeight = Math.min(buildings[left], buildings[right]);
        // check for building C that is taller than min height of left and right
        for(int i = left + 1; i < right; i++){
            if(buildings[i] > minHeight) {
                return BCWRecursive(buildings, left, i) + BCWRecursive(buildings, i, right);
            }
        }
        // find building C that is tallest building between left and right
        int maxHeight = 0;
        int maxHeightIndex = left + 1;
        for(int i = maxHeightIndex; i < right; i++){
            if(buildings[i] > maxHeight) {
                maxHeightIndex = i;
                maxHeight = buildings[i];
            }
        }
        int fill = ((right - left - 1) * (minHeight - maxHeight));
        return fill + BCWRecursive(buildings, left, maxHeightIndex) + BCWRecursive(buildings, maxHeightIndex, right);
    }

    private static int BCWIncremental(int[] buildings){
        int total = 0;
        int left = 0;
        int right = buildings.length - 1;
        int maxHeight = buildings[left];
        int index = left;
        int increment = 1;
        // max height will be the minimum between left and right
        // we will always want to be incrementing from smaller bookend to larger bookend
        if(buildings[right] < maxHeight) {
            maxHeight = buildings[right];
            increment *= -1;
            index = right;
        }
        while(left != right) {
            index += increment;
            if(buildings[index] >= maxHeight) {
                maxHeight = buildings[index];
                if(increment > 0) {
                    left = index;
                    if(buildings[right] < maxHeight) {
                        maxHeight = buildings[right];
                        increment *= -1;
                        index = right;
                    }
                } else {
                    right = index;
                    if(buildings[left] < maxHeight) {
                        maxHeight = buildings[left];
                        increment *= -1;
                        index = left;
                    }
                }
            } else {
                total += maxHeight - buildings[index];
            }

        }
        return total;
    }

    private static int[] trim(int[] buildings) {
        int left = 0;
        int right = buildings.length - 1;

        while(! (buildings[left] > buildings[left + 1] && buildings[right] > buildings[right - 1])) {
            if (buildings[left] <= buildings[left + 1]) {
                left++;
            }
            if (buildings[right] <= buildings[right - 1]) {
                right--;
            }
            if(left == right) {
                return new int[]{};
            }
        }
        int[] newBuildings = new int[right - left + 1];
        for(int i = 0; i < newBuildings.length; i++) {
            newBuildings[i] = buildings[left + i];
        }
        return newBuildings;
    }


}
