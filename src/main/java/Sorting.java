

import java.util.Collections;
import java.util.List;

/**
 * Created by sam on 6/17/16.
 */
public class Sorting {

    // implement bubble sort
    /*
        input array of sortable items?
         ints for now
         while unsorted
          loop thru entire array and if an element is less than the previous element then swap them
          if looped thru the entire array and every element is >= previous, sorted
     */

    public static List<Integer> bubbleSort(List<Integer> array) throws IllegalArgumentException {

        if(array == null) {
            throw new IllegalArgumentException("invalid input array to bubble sort: input array is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input array to bubble sort: empty array");
        }

        boolean unsorted = true;
        while(unsorted) {
            unsorted = false;
            for(int i = 1; i < array.size(); i++) {
                if(array.get(i) < array.get(i - 1)) {
                    Collections.swap(array, i, i -1);
                    unsorted = true;
                }
            }
        }

        return array;
    }
}
