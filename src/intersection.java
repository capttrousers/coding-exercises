
public class intersection {

	
    public static void main(String[] args) {
        
        String str1 = "xyz";
        String str2 = "abcdefgjagkjsodiguzoisudgoisu";
        
        
        String output = "";
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        for(int i = 0; i < len1; i++) {
    
          String c = Character.toString(str1.charAt(i));
    
          for(int j =0 ; j < len2; j++) {
            if( c.equals(Character.toString(str2.charAt(j))))
              if( ! characterInString(output,c) )
                output += c;
          }
    
        }
    
        System.out.printf("%s",output);
    
    }
    
    
    
    public static Boolean characterInString(String str, String c) {
    
        int len = str.length();
    
        for(int i = 0; i < len; i++) {
          if(c.equals(Character.toString(str.charAt(i))))
              return true;          
        }
        
        return false;
    }
	
	

}
