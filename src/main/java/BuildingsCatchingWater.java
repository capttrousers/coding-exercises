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

        int left = 0;
        int right = buildings.length - 1;

        // left and right trim
        while(left < right && buildings[left] <= buildings[left+1]) {
            left++;
        }
        while(left < right && buildings[right - 1] >= buildings[right]) {
            right--;
        }
        if(left == right) {
            return 0;
        }
        return BCW(buildings, left, right);
    }

    private static int BCW(int[] buildings, int left, int right) {
        if(! (right - left > 1)) {
            return 0;
        }
        int minHeight = Math.min(buildings[left], buildings[right]);
        // check for building C that is taller than min height of left and right
        for(int i = left + 1; i < right; i++){
            if(buildings[i] > minHeight) {
                return BCW(buildings, left, i) + BCW(buildings, i, right);
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
        return ((right - left - 1) * (minHeight - maxHeight)) + BCW(buildings, left, maxHeightIndex) + BCW(buildings, maxHeightIndex, right);
    }


}
