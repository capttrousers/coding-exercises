import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringIntersection {

	/**
	 * method that takes two strings and returns the intersection,
	 * which is the string of characters that exist in both strings
	 * order is not preserved
	 */
	public static String intersection(String str1, String str2) {
		// string of output
        String output = "";
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        
        // nested loop that checks each char in str1
        // and loops thru str2 and adds the char to output
        // if the char is in both strings and is not in output
        for(int i = 0; i < len1; i++) {
    
          char c = str1.charAt(i);
    
          for(int j =0 ; j < len2; j++) {
            if( c == str2.charAt(j))
              if( ! characterInString(output,c) )
                output += c;
          }
    
        }
    
        // print to console the output string of the intersection
        return output;
	}
	
	// helper function to check if a character exists in a string
    // returns a boolean
    public static Boolean characterInString(String str, char c) {
    
        int len = str.length();
    
        for(int i = 0; i < len; i++) {
          if(c == str.charAt(i))
              return true;          
        }
        
        return false;
    }
	
    public static void main(String[] args) { 
    	List<List<String>> testCases = new LinkedList<List<String>>();
    	testCases.add(new ArrayList<String>(Arrays.asList("abc","abe","ab")));
    	testCases.add(new ArrayList<String>(Arrays.asList("def","ddd","d")));
    	testCases.add(new ArrayList<String>(Arrays.asList("abc","xyz","")));
    	testCases.add(new ArrayList<String>(Arrays.asList("xyz","zyx","xyz")));
    	testCases.add(new ArrayList<String>(Arrays.asList("aaaaa","aaabc","aaa")));
    	testCases.add(new ArrayList<String>(Arrays.asList("xyzaaaazzzzzzzz","zzzzzzzzzzyyyyyyasdasd","yzaazzzzzzzz")));

    	for (List<String> testCase : testCases) {
    		String str1     = testCase.get(0);
    		String str2     = testCase.get(1);
    		String expected = testCase.get(2);
    		String actual   = intersection(str1, str2);
    		if (expected.equals(actual)) {
    			System.out.println("SUCCESS: test case (" + str1 + "," + str2 + ")");
    		} else {
    			System.out.println("FAILED:  test case (" + str1 + "," + str2 + ")");
    			System.out.println(" => expected: " + expected);
    			System.out.println(" => actual:   " + actual);
    		}
    	}
    }
}
