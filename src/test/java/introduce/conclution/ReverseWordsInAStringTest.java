package introduce.conclution;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInAStringTest {
    private ReverseWordsInAString reverse = new ReverseWordsInAString();

    @Test
    public void reverseWords1Test() {
        assertEquals("the sky is blue", reverse.reverseWords1("blue is sky the"));
        assertEquals("world! hello", reverse.reverseWords1("  hello world!  "));
        assertEquals("example good a", reverse.reverseWords1("a good   example"));
    }

    @Test
    public void reverseWords2Test() {
        assertEquals("the sky is blue", reverse.reverseWords2("blue is sky the"));
        assertEquals("world! hello", reverse.reverseWords2("  hello world!  "));
        assertEquals("example good a", reverse.reverseWords2("a good   example"));
    }

    @Test
    public void reverseWords3Test() {
        assertEquals("the sky is blue", reverse.reverseWords2("blue is sky the"));
        assertEquals("world! hello", reverse.reverseWords2("  hello world!  "));
        assertEquals("example good a", reverse.reverseWords2("a good   example"));
    }
}