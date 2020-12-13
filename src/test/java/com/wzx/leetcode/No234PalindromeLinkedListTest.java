package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class No234PalindromeLinkedListTest {

  private final ListNode node1 = ListNode.build(Arrays.asList(1, 2));
  private final ListNode node2 = ListNode.build(Arrays.asList(1, 2, 2, 1));

  @Test
  public void isPalindrome() {
    No234PalindromeLinkedList solution = new No234PalindromeLinkedList();
    assertFalse(solution.isPalindrome(node1));
    assertTrue(solution.isPalindrome(node2));
  }
}