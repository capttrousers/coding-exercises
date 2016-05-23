
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

		if (quantity < 0) {
			throw new IllegalArgumentException("invalid inputs to generate(). quantity less than zero: " + quantity);
		}
		if (maxValue <= 0) {
			throw new IllegalArgumentException("invalid inputs to generate(). Non positive maxValue: " + maxValue);
		}
		if (quantity > maxValue) {
			throw new IllegalArgumentException("invalid inputs to generate(). quantity greater than max value: quantity = " + quantity + ", maxValue = " + maxValue);
		}

		Set<Integer> randomSet = new HashSet<Integer>();
		// Random.nextInt(maxvalue) is exclusive
		maxValue++;

		int setCount = quantity;

		if (quantity > maxValue / 2) {
			setCount = maxValue - quantity;
		}
		for (int i = 0; i < setCount; i++) {
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
			for (int i = 0; i < maxValue; i++) {
				if (!randomSet.contains(i)) {
					list.add(i);
				}
			}

			return list;
		}
	}
}
