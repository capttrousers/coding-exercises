import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sam on 6/17/16.
 */
public class ParenthesesTest {


    @Test
    public void test1() {
        List<String> expected = Arrays.asList(
                "()");
        Assert.assertEquals(expected.size(), Parentheses.generateParentheses(1).size());
    }


    @Test
    public void test2() {
        List<String> expected = Arrays.asList(
                "(())",
                "()()");
        Assert.assertEquals(expected.size(), Parentheses.generateParentheses(2).size());
    }

    @Test
    public void test3() {
        List<String> expected = Arrays.asList(
                                            "((()))",
                                            "(()())",
                                            "(())()",
                                            "()(())",
                                            "()()()");
//        Assert.assertEquals(expected, Parentheses.generateParentheses(3));
        Assert.assertEquals(expected.size(), Parentheses.generateParentheses(3).size());
    }


    @Test
    public void test4() {
        List<String> expected = Arrays.asList("()()()()", "(())()()", "(((())))", "()((()))", "(()())()", "(()(()))", "()()(())", "()(()())", "((()()))", "((()))()", "((())())");
//        Assert.assertEquals(expected, Parentheses.generateParentheses(4));
        Assert.assertEquals(expected.size(), Parentheses.generateParentheses(4).size());
    }


}
