#include "pch.h"
#include "../../main/c++/Header.h"

class MTSLTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(MTSLTest, mergeTwoLists1Test) {
	ListNode * list1 = new ListNode(1);
	list1->next = new ListNode(2);
	list1->next->next = new ListNode(4);
	ListNode *list2 = new ListNode(1);
	list2->next = new ListNode(3);
	list2->next->next = new ListNode(4);

	MTSL solution = MTSL();
	ListNode * res = solution.mergeTwoLists1(list1, list2);
	EXPECT_EQ(1, res->val);
	EXPECT_EQ(1, res->next->val);
	EXPECT_EQ(2, res->next->next->val);
	EXPECT_EQ(3, res->next->next->next->val);
	EXPECT_EQ(4, res->next->next->next->next->val);
	EXPECT_EQ(4, res->next->next->next->next->next->val);
}

TEST_F(MTSLTest, mergeTwoLists2Test) {
	ListNode * list1 = new ListNode(1);
	list1->next = new ListNode(2);
	list1->next->next = new ListNode(4);
	ListNode *list2 = new ListNode(1);
	list2->next = new ListNode(3);
	list2->next->next = new ListNode(4);

	MTSL solution = MTSL();
	ListNode * res = solution.mergeTwoLists2(list1, list2);
	EXPECT_EQ(1, res->val);
	EXPECT_EQ(1, res->next->val);
	EXPECT_EQ(2, res->next->next->val);
	EXPECT_EQ(3, res->next->next->next->val);
	EXPECT_EQ(4, res->next->next->next->next->val);
	EXPECT_EQ(4, res->next->next->next->next->next->val);
}