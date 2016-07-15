

import java.util.*;

/**
 * Created by sam on 6/17/16.
 */
public class Sorting {

    // implement bubble sort
    /*
        input heapArray of sortable items?
         ints for now
         while unsorted
          loop thru entire heapArray and if an element is less than the previous element then swap them
          if looped thru the entire heapArray and every element is >= previous, sorted
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

    // implement merge sort
    /*
        input heapArray of sortable items?
         ints for now
         cut heapArray in half recursively until each heapArray is size 1
         merge the two subarrays by grabbing the next from the two arrays that fits sort condition
         for sorting ints ascending, grab lower of two ints
     */
    public static List<Integer> mergeSort(List<Integer> array)  throws IllegalArgumentException {
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
            int middle = (int)Math.floor((start + end) / 2d);
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array,start,middle,end);
        }

        return  array;
    }

    private static void merge(List<Integer> array, int start, int middle, int end) {

        // heapArray.subList(inclusive,exclusive) so middle will be start of right heapArray
        middle++;
        // heapArray.subList(start,end) will throw exception if(start < 0 || end > size)
        end++;
        LinkedList<Integer> leftArray = new LinkedList<Integer>(array.subList(start, middle));
        LinkedList<Integer> rightArray = new LinkedList<Integer>(array.subList(middle, end));

        int index = start;
        // two possible problems areas here: arrays are emtpy before or after end
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


    // implement heap sort
    /*
     * heap is weak binary tree stored as an array list
     * max heap has max at root, min heap has min at root
     * parent node of node at index k is Math.round((k-1)/2)
     * left child node is 2k + 1
     * right child node is left child node + 1
     * delete swaps top and bottom nodes, deletes bottom node, sifts down top node
     * sift down will compare both children for max (or min in min heap) and then if max > node, swap
     * sift up will compare to parent, if greater, swap
     * method swap
     */

    public static List<Integer> heapSort(List<Integer> array)  throws IllegalArgumentException {

        if(array == null) {
            throw new IllegalArgumentException("invalid input array to heap sort: input array is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input array to heap sort: empty array");
        }

        LinkedList<Integer> list = new LinkedList<Integer>(array);
        // I guess under the hood a PriorityQueue is a min heap
        // and to do a max heap, the PQ can be made with a comparator?
        // but this implementation doesnt involve implementing the heap itself
        // just knowing the PQ behaves like a heap with poll and add
        PriorityQueue<Integer> heapArray = new PriorityQueue<Integer>(10);
        while(! list.isEmpty()) {
            heapArray.add(list.poll());
        }
        while(! heapArray.isEmpty()) {
            list.add(heapArray.poll());
        }
        return list;
    }



    // implement quick sort
    /*
     * quicksort inputs an array
     * exceptions
     * base case = array.size() < 2 : return array
     * get pivot
     * partition on pivot into two arrays
     * if(! lessArray.isEmpty()) array.addAll(quicksort(lessArray));
     * array.add(pivot)
     * if(! moreArray.isEmpty()) array.addAll(quicksort(moreArray));
     *
     * return array
     *
     *
     */

    public static List<Integer> quickSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input array to quick sort: input array is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input array to quick sort: empty array");
        }

        ArrayList<Integer> list = new ArrayList<Integer>(array);
        // base case is array.size < 2 but we already checked for empty array and
        // we will check for empty arrays less or more than pivot and always add pivot
        int pivot = list.remove((int)Math.floor(Math.random() * list.size()));
        List<Integer> lessArray = new ArrayList<Integer>();
        List<Integer> moreArray = new ArrayList<Integer>();
        while(! list.isEmpty()) {
            int element = list.remove(0);
            if (element < pivot) {
                lessArray.add(element);
            } else {
                moreArray.add(element);
            }
        }

        if(! lessArray.isEmpty()) {
            list.addAll(quickSort(lessArray));
        }
        list.add(pivot);
        if(! moreArray.isEmpty()) {
            list.addAll(quickSort(moreArray));
        }
        return list;
    }


    // implement selection sort
    /*
     * input ArrayList
     * exceptions
     * set currentIndex to 0
     * while currentIndex array.size() - 1
     * go thru array, find min index at min value
     * if currentIndex != maxIndex
     *   swap minIndex with currentIndex
     * currentindex--;
     *
     * return array
     */

    public static List<Integer> selectionSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input array to selection sort: input array is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input array to selection sort: empty array");
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>(array);
        int currentIndex = 0;
        int size = arrayList.size();
        while(currentIndex < size) {
            int minIndex = currentIndex;
            int minValue = Integer.MAX_VALUE;
            for(int i = currentIndex; i < size; i++) {
                if(arrayList.get(i) < minValue ) {
                    minIndex = i;
                    minValue = arrayList.get(minIndex);
                }
            }

            if(currentIndex != minIndex ) {
                int temp = arrayList.get(currentIndex);
                arrayList.set(currentIndex, arrayList.get(minIndex));
                arrayList.set(minIndex, temp);
            }
            currentIndex++;
        }
        return arrayList;
    }

    // implement insertion sort
    /*
     * insertion sort has a cursor and assumes that the array to the left of the cursor is already sorted
     * cursor moves through array and grabs next element and then goes left and inserts the element into the array
     * moving all the rest of the elements forward one
     */
    public static List<Integer> insertionSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input array to insertion sort: input array is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input array to insertion sort: empty array");
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>(array);

        for(int i = 1; i < arrayList.size(); i++) {
            int c = i;
            int currentValue = arrayList.get(i);
            while(currentValue < arrayList.get(c - 1)) {
                arrayList.set(c, arrayList.get(c - 1));
                arrayList.set(c - 1, currentValue);
                c--;
                if(c < 1) break;
            }
        }
        return arrayList;
    }
}


