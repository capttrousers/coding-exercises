import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PartitioningPalindromesTest {

    public void compareExpectedWithActual(List<List<String>> expected, List<List<String>> actual) {
        Assert.assertTrue("Size between expected and actual needs to match", expected.size() == actual.size());
        for (List<String> expectedPartitioning : expected) {
            String errorMessage = "Failed to find: '" + expectedPartitioning + "' in actuals";
            Assert.assertTrue(errorMessage, actual.contains(expectedPartitioning));
        }
    }

    @Test
    public void testCase1() {
        String input = "fff";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("f", "f", "f"),
                Arrays.asList("f", "ff"),
                Arrays.asList("ff", "f"),
                Arrays.asList("fff")
        );
        List<List<String>> actual = PartitioningPalindromes.partition(input);
        compareExpectedWithActual(expected, actual);
    }

    @Test
    public void testCase2() {
        String input = "racecar";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("r", "a", "c", "e", "c", "a", "r"),
                Arrays.asList("r", "a", "cec", "a", "r"),
                Arrays.asList("r", "aceca", "r"),
                Arrays.asList("racecar")
        );
        List<List<String>> actual = PartitioningPalindromes.partition(input);
        compareExpectedWithActual(expected, actual);
    }

    @Test
    public void testCase3() {
        String input = "abbcccdddd";
        // this problem is an example of combinatorial explosion
        List<List<String>> expected = Arrays.asList(
                // varying the 'd' piece of input only
                Arrays.asList("b", "b", "c", "c", "c", "d", "d", "d", "d"),
                Arrays.asList("b", "b", "c", "c", "c", "d", "d", "dd"),
                Arrays.asList("b", "b", "c", "c", "c", "d", "ddd"),
                Arrays.asList("b", "b", "c", "c", "c", "dddd"),
                // varying the 'c' piece of input only
                Arrays.asList("b", "b", "c", "cc", "d", "d", "d", "d"),
                Arrays.asList("b", "b", "cc", "c", "d", "d", "d", "d"),
                Arrays.asList("b", "b", "ccc", "d", "d", "d", "d"),
                // varying the 'b' piece of input only
                Arrays.asList("bb", "c", "c", "c", "d", "d", "d", "d"),

                // varying the 'd' piece of input with change to 'ccc'
                Arrays.asList("b", "b", "c", "cc", "d", "d", "d", "d"),
                Arrays.asList("b", "b", "c", "cc", "d", "d", "dd"),
                Arrays.asList("b", "b", "c", "cc", "d", "ddd"),
                Arrays.asList("b", "b", "c", "cc", "dddd"),
                // varying the 'd' piece of input with change to 'ccc'
                Arrays.asList("b", "b", "cc", "c", "d", "d", "d", "d"),
                Arrays.asList("b", "b", "cc", "c", "d", "d", "dd"),
                Arrays.asList("b", "b", "cc", "c", "d", "ddd"),
                Arrays.asList("b", "b", "cc", "c", "dddd"),
                // varying the 'd' piece of input with change to 'ccc'
                Arrays.asList("b", "b", "ccc", "d", "d", "d", "d"),
                Arrays.asList("b", "b", "ccc", "d", "d", "dd"),
                Arrays.asList("b", "b", "ccc", "d", "ddd"),
                Arrays.asList("b", "b", "ccc", "dddd"),

                // varying the 'd' piece of input with change to 'ccc' and 'bb'
                Arrays.asList("bb", "c", "cc", "d", "d", "d", "d"),
                Arrays.asList("bb", "c", "cc", "d", "d", "dd"),
                Arrays.asList("bb", "c", "cc", "d", "ddd"),
                Arrays.asList("bb", "c", "cc", "dddd"),
                // varying the 'd' piece of input with change to 'ccc' and 'bb'
                Arrays.asList("bb", "cc", "c", "d", "d", "d", "d"),
                Arrays.asList("bb", "cc", "c", "d", "d", "dd"),
                Arrays.asList("bb", "cc", "c", "d", "ddd"),
                Arrays.asList("bb", "cc", "c", "dddd"),
                // varying the 'd' piece of input with change to 'ccc' and 'bb'
                Arrays.asList("bb", "ccc", "d", "d", "d", "d"),
                Arrays.asList("bb", "ccc", "d", "d", "dd"),
                Arrays.asList("bb", "ccc", "d", "ddd"),
                Arrays.asList("bb", "ccc", "dddd")
        );
        List<List<String>> actual = PartitioningPalindromes.partition(input);
        compareExpectedWithActual(expected, actual);
    }

}
