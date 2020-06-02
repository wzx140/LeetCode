package com.wzx.leetcode;


import com.wzx.entity.ListNode;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class No206ReverseLinkedListTest {

  private final ListNode node = new ListNode();

  @Before
  public void setUp() throws Exception {
    node.build(Arrays.asList(1, 2, 3, 4, 5));
  }

  @Test
  public void reverseList1Test() {
    No206ReverseLinkedList solution = new No206ReverseLinkedList();
    ListNode head = solution.reverseList1(this.node);
    Assert.assertEquals(5, head.val);
    Assert.assertEquals(4, head.next.val);
    Assert.assertEquals(3, head.next.next.val);
    Assert.assertEquals(2, head.next.next.next.val);
    Assert.assertEquals(1, head.next.next.next.next.val);
    Assert.assertNull(head.next.next.next.next.next);
  }

}
