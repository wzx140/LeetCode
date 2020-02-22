#include "header/MTSL.h"
#include "header/Utill.h"

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

 /**
  * 迭代
  * time:O(n)
  * space:O(1)
  */
ListNode* MTSL::mergeTwoLists1(ListNode* l1, ListNode* l2) {
	if (l1 == NULL && l2 == NULL) {
		return NULL;
	} else if (l1 == NULL) {
		return l2;
	} else if (l2 == NULL) {
		return l1;
	}

	ListNode* pL3 = new ListNode(0);
	ListNode* preHead = pL3;

	while (l1 != NULL || l2 != NULL) {
		if (l1 == NULL) {
			pL3->next = l2;
			l2 = l2->next;
		} else if (l2 == NULL) {
			pL3->next = l1;
			l1 = l1->next;
		} else if (l1->val > l2->val) {
			pL3->next = l2;
			l2 = l2->next;
		} else if (l1->val <= l2->val) {
			pL3->next = l1;
			l1 = l1->next;
		}
		pL3 = pL3->next;
	}
	return preHead->next;
}

/**
 * 递归
 * time:O(n)
 * space:O(n)
 */
ListNode* MTSL::mergeTwoLists2(ListNode* l1, ListNode* l2) {
	if (l1 == NULL) {
		return l2;
	} else if (l2 == NULL) {
		return l1;
	} else if (l1->val <= l2->val) {
		l1->next = mergeTwoLists2(l1->next, l2);
		return l1;
	}else if(l1->val > l2->val){
		l2->next = mergeTwoLists2(l1, l2->next);
		return l2;
	}
}
