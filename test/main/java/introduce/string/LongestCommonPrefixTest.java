package main.java.introduce.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    private String[] a = {"flower", "flow", "flight"};
    private String[] b = {"dog", "racecar", "car"};
    private LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    public void longestCommonPrefixTest() {
        String res1 = longestCommonPrefix.longestCommonPrefix(a);
        String res2 = longestCommonPrefix.longestCommonPrefix(b);
        assertEquals("fl", res1);
        assertEquals("", res2);
    }
}