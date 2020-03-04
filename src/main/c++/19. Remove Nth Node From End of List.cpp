#include "header/RNEL.h"
#include "header/Util.h"

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

 /**
  * 快慢指针
  * time:O(n)
  * space:O(1)
  */
ListNode* RNEL::removeNthFromEnd1(ListNode* head, int n) {
	ListNode* fast = head;
	ListNode* slow = head;
	ListNode* slowBefore = NULL;

	for (int i = 0; i < n - 1; i++) {
		fast = fast->next;
	}

	// 找到倒数第n个
	while (fast->next != NULL) {

		fast = fast->next;
		slowBefore = slow;
		slow = slow->next;
	}

	if (slow == head) {
		return head->next;
	}

	slowBefore->next = slow->next;

	return head;
}
