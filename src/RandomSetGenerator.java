
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomSetGenerator {

	static private Random randomNumberGenerator;
	
	public RandomSetGenerator() {
		this(new SecureRandom()); 
	}

	public RandomSetGenerator(Random generator) {
		randomNumberGenerator = generator;
	}

	public List<Integer> generate(int quantity, int maxValue) throws IllegalArgumentException {
		
		if(quantity < 0) {
			throw new IllegalArgumentException("invalid inputs to generate(). quantity less than zero: " + quantity);
		}
		if(maxValue <= 0) {
			throw new IllegalArgumentException("invalid inputs to generate(). Non positive maxValue: " + maxValue);
		}
		if(quantity > maxValue) {
			throw new IllegalArgumentException("invalid inputs to generate(). quantity greater than max value: quantity = " + quantity + ", maxValue = " + maxValue);
		}
		
		Set<Integer> randomSet = new HashSet<Integer>();
		// Random.nextInt(maxvalue) is exclusive
		maxValue++;
		
		int setCount = quantity;
		
		if( quantity > maxValue / 2) {
			setCount = maxValue - quantity;
		}
		for(int i = 0; i < setCount; i++) {
			// get random int, range 0 to maxValue + 1 because Random.nextInt(n) is exclusive
			Integer nextInt;
			do {
				nextInt = randomNumberGenerator.nextInt(maxValue);
			} while (randomSet.contains(nextInt));
			randomSet.add(nextInt);
		}
			
		if (quantity == randomSet.size()) {
			return new LinkedList<Integer>(randomSet);
		} else {
			List<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < maxValue; i++) {
				if (! randomSet.contains(i)) {
					list.add(i);
				}
			}
				
			return list;
		}
	}
	
	public static void main(String[] args) {
		List<List<Object>> testCases = new LinkedList<List<Object>>();
		testCases.add(Arrays.asList(123L, 5, 10, Arrays.asList(0, 4, 8, 9, 10)));
		testCases.add(Arrays.asList(123L, 2, 100, Arrays.asList(19, 98)));
		testCases.add(Arrays.asList(123L, 4, 5, Arrays.asList(0, 1, 3, 4)));
		testCases.add(Arrays.asList(123L, 0, 5, Arrays.asList()));
		testCases.add(Arrays.asList(123L, 6, 5, Arrays.asList()));
		testCases.add(Arrays.asList(123L, 9, 10, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8)));
		testCases.add(Arrays.asList(123L, 499990, 50000, Arrays.asList()));
		
		for (List<Object> testCase : testCases) {
			long seed = (long) testCase.get(0);
			int m = (int) testCase.get(1);
			int n = (int) testCase.get(2);
			List<Integer> expected = (List<Integer>) testCase.get(3);
			List<Integer> actual = new ArrayList<Integer>();
			try {
				actual = new RandomSetGenerator(new Random(seed)).generate(m, n);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
			// sort so we can actually compare expected vs actual values
			Collections.sort(expected);
			Collections.sort(actual);			

			if (expected.equals(actual)) {
    			System.out.println("SUCCESS: test case: generate(" + m + "," + n + ")");
    			System.out.println(" => expected: " + expected);
    		} else {
    			System.out.println("FAILED:  test case: generate(" + m + "," + n + ")");
    			System.out.println(" => expected: " + expected);
    			System.out.println(" => actual:   " + actual);
    		}
		}		
	}
	
	
}
