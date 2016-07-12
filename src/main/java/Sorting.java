

import java.util.Collections;
import java.util.LinkedList;
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

    /*
        input array of sortable items?
         ints for now
         cut array in half recursively until each array is size 1
         merge the two subarrays by grabbing the next from the two arrays that fits sort
         for sorting ints ascending, grab lower of two ints
     */
    public static List<Integer> mergeSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input array to merge sort: input array is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input array to merge sort: empty array");
        }

        return mergeSort(array, 0, array.size() - 1);
    }

    public static List<Integer> mergeSort(List<Integer> array, int start, int end) throws IllegalArgumentException {

        if(start < end) {
            int middle = Math.round((start + end) / 2);
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array,start,middle,end);
        }

        return  array;
    }

    private static void merge(List<Integer> array, int start, int middle, int end) {

        // array.subList(inclusive,exclusive) so middle will be start of right array
        middle++;
        // array.subList(start,end) will throw exception if(start < 0 || end > size)
        end++;
        LinkedList<Integer> leftArray = new LinkedList<Integer>(array.subList(start, middle));
        LinkedList<Integer> rightArray = new LinkedList<Integer>(array.subList(middle, end));

        int index = start;
        while(! (leftArray.isEmpty() && rightArray.isEmpty())){

            int value;
            if(leftArray.isEmpty()) {
                value = rightArray.remove();
            } else if(rightArray.isEmpty()) {
                value = leftArray.remove();
            } else {
                if(leftArray.getFirst() < rightArray.getFirst()) {
                    value = leftArray.remove();
                } else {
                    value = rightArray.remove();
                }
            }
            array.set(index, value);
            index++;
        }
    }
}
