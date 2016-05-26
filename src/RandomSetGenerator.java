
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomSetGenerator {

	private Random randomNumberGenerator;
	
	public RandomSetGenerator() {
		this(new SecureRandom());
	}

	public RandomSetGenerator(Random generator) {
		randomNumberGenerator = generator;
	}

	/**
	 * Generate random set of integers
	 * 
	 * @param m Number of integers in the set
	 * @param n Inclusive top of the range if potential values, [0 to n]
	 * @return List of generated integers
	 */
	public List<Integer> generate(int m, int n) {
		// maximum value is n + 1 because Random.nextInt(n) is exclusive
		int maximumValue = n + 1;
		List<Integer> randomSet = new LinkedList<Integer>();
		
		for(int i = 0; i < m; i++) { 
			randomSet.add(randomNumberGenerator.nextInt(maximumValue));
		}
		
		return randomSet;
	}
	
	public static void main(String[] args) {
		List<List<Object>> testCases = new LinkedList<List<Object>>();
		testCases.add(Arrays.asList(123L, 5, 10, Arrays.asList(0, 4, 8, 9, 10)));
		testCases.add(Arrays.asList(123L, 2, 100, Arrays.asList(19, 98)));
		testCases.add(Arrays.asList(123L, 4, 5, Arrays.asList(0, 2, 3, 5)));
		
		for (List<Object> testCase : testCases) {
			long seed = (long) testCase.get(0);
			int m = (int) testCase.get(1);
			int n = (int) testCase.get(2);
			List<Integer> expected = (List<Integer>) testCase.get(3);
			List<Integer> actual = new RandomSetGenerator(new Random(seed)).generate(m, n);
			
			// sort so we can actually compare expected vs actual values
			Collections.sort(expected);
			Collections.sort(actual);			

			if (expected.equals(actual)) {
    			System.out.println("SUCCESS: test case (" + m + "," + n + ")");
    			System.out.println(" => expected: " + expected);
    		} else {
    			System.out.println("FAILED:  test case (" + m + "," + n + ")");
    			System.out.println(" => expected: " + expected);
    			System.out.println(" => actual:   " + actual);
    		}
		}		
	}
}
