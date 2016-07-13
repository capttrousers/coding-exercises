

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
            throw new IllegalArgumentException("invalid input heapArray to bubble sort: input heapArray is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input heapArray to bubble sort: empty heapArray");
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
    public static List<Integer> mergeSort(List<Integer> array) {
        if(array == null) {
            throw new IllegalArgumentException("invalid input heapArray to merge sort: input heapArray is null");
        }

        if(array.isEmpty()) {
            throw new IllegalArgumentException("invalid input heapArray to merge sort: empty heapArray");
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

        // heapArray.subList(inclusive,exclusive) so middle will be start of right heapArray
        middle++;
        // heapArray.subList(start,end) will throw exception if(start < 0 || end > size)
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

    public static List<Integer> heapSort(List<Integer> array) {
        // to allow this constructor call, i had to make the class static
        MaxHeap heap = new MaxHeap(array);
        return heap.sort();
    }



    public static class MaxHeap {
        PriorityQueue<Integer> heapArray;




        public MaxHeap(List<Integer> array) {
            heapArray = new PriorityQueue<Integer>(10);
            while(! array.isEmpty()) {
                heapArray.add(array.remove(array.size() - 1));
            }
        }

//        private void siftUp(int index) {
//            while(index > 0) {
//                int comparison = heapArray.compare()
//                // for min heap, this will check for less than parent
//                if(heapArray.get(index) > heapArray.get(parent(index))) {
//                    swap(index,parent(index));
//                    index = parent(index);
//                } else {
//                    index = 0;
//                }
//            }
//        }
//
//        private void siftDown(int index) {
//            while(index < heapArray.size() - 1) {
//                // max is index of max child
//                int max = heapArray.indexOf(Math.max(heapArray.get(leftChild(index)), heapArray.get(rightChild(index))));
//                if(heapArray.get(index) < heapArray.get(max)) {
//                    swap(index, max);
//                    index = max;
//                } else {
//                    index = heapArray.size();
//                }
//            }
//        }
//        // returns index of the parent node of node at index
//        private int parent(int index) {
//            return Math.round((index - 1) / 2);
//        }
//
//        private int leftChild(int index) {
//            return (2 * index) + 1;
//        }
//
//        private int rightChild(int index) {
//            return  leftChild(index) + 1;
//        }
//
//        // swaps objects at indices one and two in heapArray
//        private void swap(int one, int two) {
//            Integer temp = heapArray.get(one);
//            heapArray.set(one, heapArray.get(two));
//            heapArray.set(two, temp);
//        }
//
//        // exception for empty array
//        public Integer remove(int index) {
//            Integer node = heapArray.get(index);
//            swap(index, heapArray.size() - 1);
//            heapArray.remove(heapArray.size() - 1);
//            siftDown(index);
//            return node;
//        }
//
//        public void add(int value) {
//            heapArray.add(Integer.valueOf(value));
//            siftUp(heapArray.size() - 1);
//        }

        public List<Integer> sort() {

            LinkedList<Integer> list = new LinkedList<Integer>();
            while(! heapArray.isEmpty()) {
                list.addFirst(heapArray.poll());
            }
            return list;
        }

    }
}


