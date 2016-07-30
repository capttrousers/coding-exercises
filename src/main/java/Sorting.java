

import java.util.*;

/**
 * Created by sam on 6/17/16.
 */
public class Sorting {

    /*
     * Bubble sort iterates thru array and compares value to previous then swaps them when previous is greater
     * On average, running time: (O) = n^2
     * @param array Array to be sorted
     * @return sorted array
     * @throws illegal argument exception on null array
     */

    public static List<Integer> bubbleSort(List<Integer> array) throws IllegalArgumentException {

        if(array == null) {
            throw new IllegalArgumentException("invalid input array to bubble sort: input array is null");
        }

        if(array.isEmpty()) {
            return array;
        }

        boolean unsorted = true;
        while(unsorted) {
            unsorted = false;
            for(int i = 1; i < array.size(); i++) {
                if(array.get(i) < array.get(i - 1)) {
                    Collections.swap(array, i, i - 1);
                    unsorted = true;
                }
            }
        }

        return array;
    }

    /*
     * Merge sort checks array and if bigger than one element, recursively calls merge sort on list broken in two
     * On average, running time: (O) = n lg n
     * @param list List to be sorted
     * @return Sorted array
     * @throws Illegal argument exception on null array
     */
    public static List<Integer> mergeSort(List<Integer> list)  throws IllegalArgumentException {
        if(list == null) {
            throw new IllegalArgumentException("invalid input array to merge sort: input array is null");
        }

        if(list.isEmpty() || list.size() == 1) {
            return list;
        }
        int middle = (int)Math.floor(list.size() / 2);
        // list.subList(inclusive,exclusive) throws error if end > list.size
        List<Integer> leftArray = mergeSort(list.subList(0,middle));
        List<Integer> rightArray = mergeSort(list.subList(middle,list.size()));
        List<Integer> sortedList = merge(leftArray, rightArray);
        return  sortedList;
    }

    /*
     * Merge is called by merge sort to merge together two sorted sub arrays by grabbing the next value
     * from the two arrays that fits sort condition. For sorting ints ascending, grab lower of two ints. @see #mergeSort
     * @param leftList First list to be merged with second
     * @param rightList Second list to be merged together
     */
    private static ArrayList<Integer> merge(List<Integer> leftList, List<Integer> rightList) {

        LinkedList<Integer> leftArray = new LinkedList<Integer>(leftList);
        LinkedList<Integer> rightArray = new LinkedList<Integer>(rightList);
        ArrayList<Integer> array = new ArrayList<Integer>();

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
            array.add(value);
        }
        return array;
    }


    /*
     * Heap sort utilizes the Heap implementation of the PriorityQueue util java class.
     * Adds all elements from array to PQ and pops them off the PQ until empty to get sorted array.
     * On average, running time: (O) = n lg n
     * @param array Array to be sorted
     * @return Sorted array
     * @throws Illegal argument exception on null array
     */
    public static List<Integer> heapSort(List<Integer> array)  throws IllegalArgumentException {

        if(array == null) {
            throw new IllegalArgumentException("invalid input array to heap sort: input array is null");
        }

        if(array.isEmpty()) {
            return array;
        }

        LinkedList<Integer> list = new LinkedList<Integer>(array);
        // I guess under the hood a PriorityQueue is a min heap
        // and to do a max heap, the PQ can be made with a comparator?
        // but this implementation doesnt involve implementing the heap itself
        // just knowing the PQ behaves like a heap with poll and add
        PriorityQueue<Integer> heapArray = new PriorityQueue<Integer>();
        Iterator<Integer> i = list.iterator();
        while(i.hasNext()) {
            heapArray.add(i.next());
        }
        list.clear();
        while(! heapArray.isEmpty()) {
            list.add(heapArray.poll());
        }
        return list;
    }



    /*
     * Quick sort finds a middle pivot element, partitions all elements greater or less than the pivot
     * and then recursively calls quick sort on both partitions until each partition is size one.
     * On average, running time: (O) = n lg n
     * @param array Array to be sorted
     * @return Sorted array
     * @throws Illegal argument exception on null array
     */

    public static List<Integer> quickSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input array to quick sort: input array is null");
        }

        if(array.isEmpty()) {
            return array;
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


    /*
     * Selection sort iterates over array, then finds and moves the min or max value, to front or back respectively.
     * Repeats until the section of the array to be sorted is just the first or last element.
     * On average, running time: (O) = n ^ 2
     * @param array Array to be sorted
     * @return Sorted array
     * @throws Illegal argument exception on null array
     */

    public static List<Integer> selectionSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input array to selection sort: input array is null");
        }

        if(array.isEmpty()) {
            return array;
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

    /*
     * Insertion sort has a cursor in the array and assumes the subarray to the left of the cursor is already sorted.
     * Cursor moves through array and grabs next element and inserts the element into the sorted array, moving all the rest of the elements forward one
     * On average, running time: (O) = n ^ 2
     * @param array Array to be sorted
     * @return Sorted array
     * @throws Illegal argument exception on null array
     */
    public static List<Integer> insertionSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input array to insertion sort: input array is null");
        }

        if(array.isEmpty()) {
            return array;
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


