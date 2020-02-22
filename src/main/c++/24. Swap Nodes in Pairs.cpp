#include "header/SNP.h"
#include "header/Utill.h"

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */

void recursive(ListNode* pre, ListNode* node1, ListNode* node2, ListNode* post) {
	pre->next = node2;
	node2->next = node1;
	node1->next = post;

	if (post != NULL && post->next != NULL) {
		recursive(node1, post, post->next, post->next->next);
	}
}

/**
 * 递归
 * time:O(n)
 * space:O(1)
 */
ListNode* SNP::swapPairs1(ListNode* head) {
	if (head == NULL || head->next == NULL) {
		return head;
	}

	// 哨兵
	ListNode* sentinel = new ListNode(0);
	sentinel->next = head;

	recursive(sentinel, head, head->next, head->next->next);
	return sentinel->next;
}

/**
 * 迭代
 * time:O(n)
 * space:O(1)
 */
ListNode* SNP::swapPairs2(ListNode* head) {
	if (head == NULL || head->next == NULL) {
		return head;
	}

	// 哨兵
	ListNode* sentinel = new ListNode(0);
	sentinel->next = head;

	ListNode* pre = sentinel;
	ListNode* node1 = pre->next;
	ListNode* node2 = node1->next;
	ListNode* post = node2->next;

	while (node2 != NULL) {

		pre->next = node2;
		node2->next = node1;
		node1->next = post;

		pre = node1;
		node1 = post;
		if (post != NULL && post->next != NULL) {
			node2 = post->next;
			post = post->next->next;
		} else {
			node2 = NULL;
		}

	}
	return sentinel->next;
}
