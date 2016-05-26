import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.util.Random;

public class Tests {

    public static void main(String[] args) { 
    	
      	RandomSetGenerator randomSetGenerator;
    	
    	/*
    	 * 
    	 * This test is for random set generation, m numbers from 0 to n
    	 * using Random class with a seed to test algo
    	 * 
    	 * each random set will be associated with a seed. to test, we will 
    	 * loop and use the seed to make an instance of the RandomSetGenerator class
    	 * then we will test the m,n combo and compare the output to the test.expected
    	 * 
    	 * test.expected will be made first with a loop and Math.random for m,n
    	 * and then stored : long seed, int m, int n, int[] expected
    	 * 
    	 * 
    	 */
    	
    	// delete this to seed randomly
    	long seed = 123456790;
    	
    	// limit m and n to 10
    	int limit = 10;
    	
    	// create test cases for RandomSetGenerator   	
    	List<RandomTest> testCases = new ArrayList<RandomTest>();

    	// only do 1 test case
    	for(int i = 0; i < 1; i++) {
    		
    		// limit m and n to 10
//    		int m = (int)(Math.random() * limit);
//    		int n = (int)(Math.random() * limit);
    		int m = limit;
    		int n = limit;
    		
    		// to set seed global to configure tests
//    		long seed = System.currentTimeMillis();
    		randomSetGenerator = new RandomSetGenerator(new Random(seed));

    		// forcing failure of comparison to print values 
//    		int[] expected = randomSetGenerator.generate(m, n);
    		int[] expected = {-1};
    		
    		testCases.add(new RandomTest(seed, m, n, expected));
    	}
    	

    	for (RandomTest testCase : testCases ) {
    		randomSetGenerator = new RandomSetGenerator(new Random(testCase.seed));
    		List<Integer> actual = randomSetGenerator.generate(testCase.m, testCase.n);
    		    		
    		if (Arrays.toString(testCase.expected).equals(Arrays.toString(actual.toArray()))) {
    			System.out.println("SUCCESS!");
    			System.out.println("expected int array: " + Arrays.toString(testCase.expected));
    			System.out.println("actual int array: " + Arrays.toString(actual.toArray()));
    			System.out.println();
    		} else {
    			System.out.println("FAIL");
    			System.out.println("expected int array: " + Arrays.toString(testCase.expected));
    			System.out.println("actual int array: " + Arrays.toString(actual.toArray()));
    			System.out.println();
    		}
    		
    		
    	}
    }
}

// class to instantiate, will hold a seed, ints m & n, int[] expected
class RandomTest {
	
	public int n,m;
	public long seed;
	public int[] expected;
	
	public RandomTest(long seed, int m, int n, int[] expected) {
		this.n = n;
		this.m = m;
		this.expected = expected;
		this.seed = seed;
	}
	
}
