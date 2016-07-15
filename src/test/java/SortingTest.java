import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sam on 6/17/16.
 */
public class SortingTest {

    // to create an heapArray of 10 random ints between 0 and 100 for use in tests
    private List<Integer>  randomArray() {
        List<Integer> array = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++) {
            array.add((int) (Math.random() * 100));
        }

        return array;
    }
    
    
    private void check(List<Integer> toSort, List<Integer> expected) {
        Assert.assertEquals(expected, Sorting.bubbleSort(toSort));
        Assert.assertEquals(expected, Sorting.mergeSort(toSort));
        Assert.assertEquals(expected, Sorting.heapSort(toSort));
        Assert.assertEquals(expected, Sorting.quickSort(toSort));
        Assert.assertEquals(expected, Sorting.selectionSort(toSort));
        Assert.assertEquals(expected, Sorting.insertionSort(toSort));
    }

    

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test1() {
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> toCheck = Arrays.asList(10,9,6,1,7,2,3,5,4,8);
        check(toCheck, expected);
    }

    @Test
    public void test2() {
        List<Integer> expected = Arrays.asList(0, 14, 19, 27, 48, 56, 58, 60, 65, 71);
        List<Integer> toCheck = Arrays.asList(58, 19, 60, 14, 0, 27, 48, 56, 71, 65);
        check(toCheck, expected);
    }

    @Test
    public void test3() {
        List<Integer> expected = Arrays.asList(16, 24, 30, 38, 58, 68, 68, 82, 88, 98);
        List<Integer> toCheck = Arrays.asList(82, 30, 24, 16, 38, 58, 88, 68, 68, 98);
        check(toCheck, expected);
    }

    @Test
    public void emptyArrayTest() {
        List<Integer> expected = new ArrayList<Integer>();
        check(new ArrayList<Integer>(), expected);
    }


    @Test
    public void nullArray() {
        thrown.expect(IllegalArgumentException.class);
        List<Integer> expected = new ArrayList<Integer>();
        check(null, expected);
    }
    /*
        @Test
        public void test() {
            List<Integer> expected = randomArray();
            List<Integer> toCheck = Arrays.asList(10,9,6,1,7,2,3,5,4,8);
            check(expected,actual);
        }
     */

}
