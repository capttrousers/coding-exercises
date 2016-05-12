
public class intersection {

	
    public static void main(String[] args) {
        
    	// class that takes two strings, str1 and str2
    	// and returns a string, output, that contains the intersection
    	// which is the string of characters that exist in both strings
    	// duplicates are removed and order is not preserved
    	
    	// two strings of input
        String str1 = "xyzaaaazzzzzzzz";
        String str2 = "zzzzzzzzzzyyyyyyasdasd";
        
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
        System.out.printf("%s",output);
    
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
	
	

}
