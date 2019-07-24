#include "Utills.h"
using namespace data;
#include "Header.h"

ListNode* AddTwoNumbers::addTwoNumbers1(ListNode* l1, ListNode* l2) {
	int carry = 0;
	ListNode * res = new ListNode(0);
	ListNode * temp = res;
	while (l1 != NULL && l2 != NULL){
		int num1 = 0;
		int num2 = 0;
		if(l1 != NULL){
			num1 = l1->val;
			l1 = l1->next;
		}
		if(l2 != NULL){
			num2 = l2->val;
			l2 = l2->next;
		}
		int add = num1 + num2 + carry;
		temp->next = new ListNode(add % 10);
		temp = temp->next;
		carry = add / 10;
	}
	if(carry){
		temp->next = new ListNode(1);
	}
	return res->next;
}