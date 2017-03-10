import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by sam on 3/7/17.
 */
public class Parentheses {

    public static List<String> generateParentheses(int n) {

        if(n == 0) {
            return new LinkedList<String>(Arrays.asList(""));
        }
        if(n == 1) {
            return new LinkedList<String>(Arrays.asList("()"));
        }
        // brute force is to start with a string of n good parentheses '()'
        // then starting from right, grab first open parentheses, move to the left until at start
        // each iteration check for valid set of parentheses, and add to results list
        // then do n-- and find next open parentheses, to find all n open parentheses
        // actually use a hash set to only keep a set of combos
        Set<String> results = new HashSet<>();
        StringBuilder str = new StringBuilder();
        for(int i = 1; i <= n; i++){
            str.append("()");
        }
        results.add(str.toString());

        for(int i = 2; i <= n; i++) {
//            int l = str.lastIndexOf("(");
            int l = str.indexOf("(");
            // grab i-th from front '('
            for(int k = 2; k <= i; k++) {
                l = str.indexOf("(", l + 1);
            }
            // pull that '(' to front
            for(int j = l - 1; j >= 0; j--) {
                str.setCharAt(j + 1, str.charAt(j));
                str.setCharAt(j, '(');
                if(isValidParenthesesString(str.toString()) && ! results.contains(str.toString())) {
                    results.add(str.toString());
                }
            }
        }

        for(int i = 1; i < n; i++) {
//            int l = str.lastIndexOf("(");
            int l = str.indexOf(")");
            // grab i-th from front '('
            for(int k = 2; k <= i; k++) {
                l = str.indexOf(")", l + 1);
            }
            //
            for(int j = l - 1; j > 0; j--) {
                // in this boolean, replace '(' then length() will count ')'
                if (str.substring(j + 2).replace("(", "").length() > str.substring(j + 2).replace(")", "").length()) {
                    str.setCharAt(j + 1, str.charAt(j));
                    str.setCharAt(j, ')');
                    if(! results.contains(str.toString()) && isValidParenthesesString(str.toString()) ) {
                        results.add(str.toString());
                    }
                }
            }
        }
        return new LinkedList<>(results);

    }

    private static boolean isValidParenthesesString(String s) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            if(s.charAt(i) == ')') right++;
            if(right > left) return false;
        }
        // if (, left++; if ), right++
        // if right > left, return false
        return true;
    }

}
