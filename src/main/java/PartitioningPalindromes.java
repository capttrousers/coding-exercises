import java.util.LinkedList;
import java.util.List;

class PartitioningPalindromes {
    /**
     * Given a string, print all palindromic partitions.
     */
    public static List<List<String>> partition(String input) {
        List<List<String>> palindromes = new LinkedList<List<String>>();
        /*
               1. first start with exploded string
               or
               2. first start with full string

               full string:
                "abbcccdddd"
                palLength = n = 10
                isPalindrome?

                n - 1
                "a" "bbcccdddd"
                "abbcccddd" "d"

                n - 2
                "ab" "bcccdddd"
                "a" "b" "bcccdddd"
                "a" "bbcccddd" "d"
                "abbcccdd" "dd"
                "abbcccdd" "d" "d"

                n - 3
                "abb" "cccdddd"
                "a" "bb" "cccdddd"
                "ab" "b" "cccdddd"
                "a" "b" "b" "cccdddd"
                "ab" "bcccddd" "d"
                "a" "b" "bcccddd" "d"
                "a" "bbcccdd" "dd"
                "a" "bbcccdd" "d" "d"
                "abbcccd" "ddd"

                n - 4
                "abbc" "ccdddd"
                "abb" "cccddd" "d"
                "ab" "bcccdd" "dd"
                "a" "bbcccd" "ddd"
                "abbccc" "dddd"

                n - 5
                "abbcc" "cdddd"
                "abbc" "ccddd" "d"
                "abb" "cccdd" "dd"
                "ab" "bcccd" "ddd"
                "a" "bbccc" "dddd"
                "abbcc" "cdddd"

                n - 6
                "abbccc" "dddd"
                "abbcc" "cddd" "d"
                "abbc" "ccdd" "dd"
                "abb" "cccd" "ddd"
                "ab" "bccc" "dddd"
                "a" "bbcc" "cdddd"
                "abbc" "ccdddd"

                n - 7
                "abbcccd" "ddd"
                "abbccc" "ddd" "d"
                "abbcc" "cdd" "dd"
                "abbc" "ccd" "ddd"
                "abb" "ccc" "dddd"
                "ab" "bcc" "cdddd"
                "a" "bbc" "ccdddd"
                "abb" "cccdddd"

                n - 8
                "abbcccdd" "dd"
                "abbcccd" "dd" "d"
                "abbccc" "dd" "dd"
                "abbcc" "cd" "ddd"
                "abbc" "cc" "dddd"
                "abb" "cc" "cdddd"
                "ab" "bc" "ccdddd"
                "a" "bb" "cccdddd"
                "ab" "bcccdddd"

                n - 9
                "abbcccddd" "d"
                "abbcccdd" "d" d"
                "abbcccd" "d" "dd"
                "abbccc" "d" "ddd"
                "abbcc" "c" "dddd"
                "abbc" "c" "cdddd"
                "abb" "c" "ccdddd"
                "ab" "b" "cccdddd"
                "a" "b" "bcccdddd"








         */

        return palindromes;
    }

    private static boolean isPalindrome(String input) {
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
