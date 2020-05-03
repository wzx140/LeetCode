package com.wzx.leetcode;


import com.wzx.entity.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class No206ReverseLinkedListTest {

  private ListNode node = null;

  @Before
  public void setUp() throws Exception {
//    1->2->3->4->5->NULL
    node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
  }

  @Test
  public void reverseList1Test() {
    No206ReverseLinkedList solution = new No206ReverseLinkedList();
    ListNode head = solution.reverseList1(this.node);
    Assert.assertEquals(5,head.val);
    Assert.assertEquals(4,head.next.val);
    Assert.assertEquals(3,head.next.next.val);
    Assert.assertEquals(2,head.next.next.next.val );
    Assert.assertEquals(1,head.next.next.next.next.val);
    Assert.assertNull(head.next.next.next.next.next);
  }

}
