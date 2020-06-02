package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class No92ReverseLinkedList2Test {

  private final ListNode node = new ListNode();

  @Before
  public void setUp() throws Exception {
    node.build(Arrays.asList(1, 2, 3, 4,5));
  }

  @Test
  public void reverseBetweenTest() {
    No92ReverseLinkedList2 solution = new No92ReverseLinkedList2();
    ListNode head = solution.reverseBetween(this.node, 2, 4);
//    1->4->3->2->5->NULL
    Assert.assertEquals(1,head.val);
    Assert.assertEquals(4,head.next.val);
    Assert.assertEquals(3,head.next.next.val);
    Assert.assertEquals(2,head.next.next.next.val );
    Assert.assertEquals(5,head.next.next.next.next.val);
    Assert.assertNull(head.next.next.next.next.next);
  }
}