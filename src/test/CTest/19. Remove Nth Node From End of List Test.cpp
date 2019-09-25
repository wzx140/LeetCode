#include "pch.h"
#include "../../main/c++/Header.h"

class RNELTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(RNELTest, removeNthFromEnd1Test) {
	ListNode * list = new ListNode(1);
	list->next = new ListNode(2);
	list->next->next = new ListNode(3);
	list->next->next->next = new ListNode(4);
	list->next->next->next->next = new ListNode(5);

	RNEL solution = RNEL();
	ListNode * res = solution.removeNthFromEnd1(list, 2);
	EXPECT_EQ(1, res->val);
	EXPECT_EQ(2, res->next->val);
	EXPECT_EQ(3, res->next->next->val);
	EXPECT_EQ(5, res->next->next->next->val);
}