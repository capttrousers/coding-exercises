import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class StringIntersection {

	/**
	 * method that takes two strings and returns the intersection,
	 * which is the string of characters that exist in both strings
	 * order is not preserved
	 * 
	 * This is accomplished with a hash map.
	 * HashMap<Character, Integer>
	 * first put a count of all chars in str1 into HashMap
	 * loop thru str2 and if get(c) > 0 
	 * then output.append and replace(Integer--)
	 *  
	 * returns empty string if no intersection of characters
	 */
	public static String intersection(String str1, String str2) {

		// check nulls and empty strings
		if(str1 == null || str1.equals("") || str2 == null || str2.equals("")) {
			return "";			
		}
		
		// put shorter String up front
		if(str2.length() < str1.length()) {
			String ph = str2;
			str2 = str1;
			str1 = ph;
		}
		
		// create hash map to hold Character => Integer 
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		Character c;
		StringBuilder output = new StringBuilder();

		for(int i = 0; i < str1.length(); i++) {
			c = new Character(str1.charAt(i));
			/*
			 * loop through str1 to create or increment the
			 * Integer value for the count of chars c  in str1
			 * if a char exists in str1 one or more times,
			 * the Integer value will be the count of chars
			 */
			if(hm.containsKey(c)) {
				hm.replace(c, new Integer(hm.get(c).intValue() + 1));
			} else {
				hm.put(c, new Integer(1));
			}
		}

		// should i pull out the strX.length() calls since im not touching those strings?
		for(int i = 0; i < str2.length(); i++) {
			c = new Character(str2.charAt(i));
			/*
			 * if hashmap has Key c : Character exists in str1 
			 * if Integer value > 0 : still chars available for intersection
			 * then append char to output
			 * and decrement the Integer value of count of chars
			 */
			if(hm.containsKey(c) && hm.get(c).intValue() > 0) {
				output.append(c.toString());
				if(output.length() >= str1.length()) {
					return output.toString();
				}
				// should i put an else here? 
				// or put the output.append into the if statment?
				// if i did that, the append would run and then check the length, yea?
				hm.replace(c, new Integer(hm.get(c).intValue() - 1));
			}
		}		
		
		return output.toString(); 
	}
		
	/*
	 * helper function to take a String and sort it alphabetically
	 * takes the String, converts to char[] then Arrays.sort(charArray)
	 * returns sorted string
	 */
	public static String sortString(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return (new String(charArray));		
	}
	
	
	
    public static void main(String[] args) { 
    	List<List<String>> testCases = new LinkedList<List<String>>();
    	testCases.add(new ArrayList<String>(Arrays.asList("abc","abe","ab")));
    	testCases.add(new ArrayList<String>(Arrays.asList("def","ddd","d")));
    	testCases.add(new ArrayList<String>(Arrays.asList("abc","xyz","")));
    	testCases.add(new ArrayList<String>(Arrays.asList("xyz","zyx","xyz")));
    	testCases.add(new ArrayList<String>(Arrays.asList("aaaaa","aaabc","aaa")));
    	testCases.add(new ArrayList<String>(Arrays.asList("xyzaaaazzzzzzzz","zzzzzzzzzzyyyyyyasdasd","yzaazzzzzzzz")));
    	testCases.add(new ArrayList<String>(Arrays.asList(null,"asoidj","")));
    	testCases.add(new ArrayList<String>(Arrays.asList("asdasd",null,"")));
    	testCases.add(new ArrayList<String>(Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaa","aaaaaaaaa")));
    	testCases.add(new ArrayList<String>(Arrays.asList("aaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaa")));
    	// for adding new test cases
    	// testCases.add(new ArrayList<String>(Arrays.asList(,,"")));
    	
    	for (List<String> testCase : testCases) {
    		String str1     = testCase.get(0);
    		String str2     = testCase.get(1);
    		// sort both strings alphabetically
    		String expected = sortString(testCase.get(2)); 
    		String actual   = sortString(intersection(str1, str2));
    		if (expected.equals(actual)) {
    			System.out.println("SUCCESS: test case (" + str1 + "," + str2 + ")");
    			System.out.println(" => expected: " + expected);
    		} else {
    			System.out.println("FAILED:  test case (" + str1 + "," + str2 + ")");
    			System.out.println(" => expected: " + expected);
    			System.out.println(" => actual:   " + actual);
    		}
    	}
    }
}
