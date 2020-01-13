package introduce.conclution;

import org.junit.Test;
import per.wzx.introduce.conclution.ReverseWordsInAStringIII;

import static org.junit.Assert.*;

public class ReverseWordsInAStringIIITest {
    private ReverseWordsInAStringIII reverse = new ReverseWordsInAStringIII();

    @Test
    public void reverseWords1Test() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverse.reverseWords1("Let's take LeetCode contest"));
    }

    @Test
    public void reverseWords2Test() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverse.reverseWords2("Let's take LeetCode contest"));
    }

    @Test
    public void reverseWords3Test() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverse.reverseWords3("Let's take LeetCode contest"));
    }
}