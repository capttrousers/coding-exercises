import java.util.LinkedList;
import java.util.List;

class PartitioningPalindromes {
    /**
     * Given a string, print all palindromic partitions.
     */
    public static List<List<String>> partition(String input) throws IllegalArgumentException {
        if(input.isEmpty() || input == null){
            throw new IllegalArgumentException("invalid inputs to partition(), requires string of length >= 1");
        }

        // solution is a single possible palindromic partition
        // palindromic partition is a way to split chars of input string that still contains all palindromes
        List<String> solution = new LinkedList<>();

        // palindromes is all the possible solutions for str of length = n
        List<List<String>> output = new LinkedList<>();
        if(input.length() == 1) {
            solution.add(input);
            output.add(solution);
            return output;
        }

        // we create a List of outputs for each substring of length 1 -> n
        List<List<List<String>>> outputList = new LinkedList<>();

        // string.substring is 0 indexed, exclusive top end
        solution.add(input.substring(0,1));
        output.add(solution);
        outputList.add(output);
        // cursor is 0 indexed, like input string, and starts at second char bc input.length > 1
        int cursor = 1;
        while(cursor < input.length()) {
            String newChar = input.substring(cursor, cursor + 1);
            // first add new char to all solutions from previous output
            // 1. copy output to newOutput
            // 2. for each solution in output:append new char to solution, add new solution to newOutput
            List<List<String>> newOutput = new LinkedList<>();
            for (List<String> subSolution : output) {
                subSolution.add(newChar);
                newOutput.add(subSolution);
            }
            // then check all possible substrings from right to left for palindromes
            for(int pivot = cursor - 1; pivot >= 0; pivot--) {
                String mirror = input.substring(pivot, pivot + 1);
                if(mirror.equals(newChar) && isPalindrome(input.substring(pivot + 1, cursor))) {
                    String palindrome = input.substring(pivot, cursor + 1);
                    if(pivot == 0) {
                        solution.clear();
                        solution.add(palindrome);
                        newOutput.add(solution);
                    } else {
                        output = outputList.get(pivot - 1);
                        for (List<String> subSolution : output) {
                            subSolution.add(palindrome);
                            newOutput.add(subSolution);
                        }
                    }
                }
            }
            outputList.add(newOutput);
            cursor++;
        }
        // return output for string length = n, which is all palindromes for input string
        return output;
    }

    private static boolean isPalindrome(List<String> input) {
        for (String partition : input) {
            if(! isPalindrome(partition)) {
                return false;
            }
        }
        return true;
    }
    private static boolean isPalindrome(String input) {
        if(input.isEmpty()) {
            return true;
        }
        char[] str = input.toCharArray();
        int left, right;
        if(str.length % 2 == 1) {
            left = ((str.length - 1) / 2) - 1;
            right = left + 2;
        } else {
            left = (str.length / 2) - 1;
            right = left + 1;
        }
        while(left >= 0 && right < str.length) {
            if(str[left] != str[right]) {
                return false;
            } else {
                left--;
                right++;
            }
        }
        return true;
    }
}
