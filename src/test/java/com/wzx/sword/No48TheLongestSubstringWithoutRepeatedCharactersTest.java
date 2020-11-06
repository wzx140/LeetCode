package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No48TheLongestSubstringWithoutRepeatedCharactersTest {

  private final String str1 = "abcabcbb";
  private final String str2 = "bbbbb";
  private final String str3 = "pwwkew";

  @Test
  public void lengthOfLongestSubstring1() {
    No48TheLongestSubstringWithoutRepeatedCharacters solution = new No48TheLongestSubstringWithoutRepeatedCharacters();
    assertEquals(3, solution.lengthOfLongestSubstring1(str1));
    assertEquals(1, solution.lengthOfLongestSubstring1(str2));
    assertEquals(3, solution.lengthOfLongestSubstring1(str3));
  }

  @Test
  public void lengthOfLongestSubstring2() {
    No48TheLongestSubstringWithoutRepeatedCharacters solution = new No48TheLongestSubstringWithoutRepeatedCharacters();
    assertEquals(3, solution.lengthOfLongestSubstring2(str1));
    assertEquals(1, solution.lengthOfLongestSubstring2(str2));
    assertEquals(3, solution.lengthOfLongestSubstring2(str3));
  }
}