import org.junit.Assert;
import org.junit.Test;

public class StringIntersectionTest {

    private void checkStringEquality(String expected, String string1, String string2) {
        String sorted = StringIntersection.sortString(StringIntersection.intersection(string1, string2));
        Assert.assertEquals(expected, sorted);
    }

    @Test
    public void testCase1() {
        String string1 = "abc";
        String string2 = "abe";
        String expected = "ab";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void testCase2() {
        String string1 = "def";
        String string2 = "ddd";
        String expected = "d";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void testCase3() {
        String string1 = "abc";
        String string2 = "xyz";
        String expected = "";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void testCase4() {
        String string1 = "xyz";
        String string2 = "zyx";
        String expected = "xyz";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void testCase5() {
        String string1 = "aaaaa";
        String string2 = "aaabc";
        String expected = "aaa";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void testCase6() {
        String string1 = "xyzaaaazzzzzzzz";
        String string2 = "zzzzzzzzzzyyyyyyasdasd";
        String expected = "aayzzzzzzzzz";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void firstStringNull() {
        String string1 = null;
        String string2 = "asoidj";
        String expected = "";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void secondStringNull() {
        String string1 = "asdasd";
        String string2 = null;
        String expected = "";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void bothStringsNull() {
        String string1 = null;
        String string2 = null;
        String expected = "";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void longFirstString() {
        String string1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String string2 = "aaaaaaaaa";
        String expected = "aaaaaaaaa";
        checkStringEquality(expected, string1, string2);
    }

    @Test
    public void longSecondString() {
        String string1 = "aaaaaaaaa";
        String string2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String expected = "aaaaaaaaa";
        checkStringEquality(expected, string1, string2);
    }
}