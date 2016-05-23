
import java.security.SecureRandom;
import java.util.Random;

public class RandomSetGenerator {

	static private SecureRandom random;
	
	// constructor for an instance of RandomSetGenerator
	// takes a seed to be passed on construction
	// default constructor uses current system time
	public RandomSetGenerator() {
		this(System.currentTimeMillis());     	// use the current system time for the seed to Random
	}

	// test constructor takes a seed in order to test the random sequence
	public RandomSetGenerator(long seed) {
		random = new SecureRandom();
		random.setSeed(seed);
	}

	public int[] generate(int m, int n) {
		// m is the number of ints in the set
		// n is the inclusive top of the range if potential values, [0 to n]
		int[] randomSet = new int[m];
		
		for(int i = 0; i < m; i++) {
			// get the next random int, range 0 to n+1 : n + 1 because nextInt(n) is exclusive
			randomSet[i] = random.nextInt(n+1);
		}
		
		return randomSet;
	}
}
