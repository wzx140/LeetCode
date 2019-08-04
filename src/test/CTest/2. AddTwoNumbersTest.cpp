#include "pch.h"
#include "../../main/c++/Header.h"

class AddTwoNumbersTest : public ::testing::Test {
protected:
	void SetUp() override {
	}

	void TearDown() override {
	}
};

TEST_F(AddTwoNumbersTest, addTwoNumbers1Test) {
	ListNode * num1 = new ListNode(2);
	num1->next = new ListNode(4);
	num1->next->next = new ListNode(3);

	ListNode * num2 = new ListNode(5);
	num2->next = new ListNode(6);
	num2->next->next = new ListNode(4);

	AddTwoNumbers addTwoNumbers = AddTwoNumbers();
	ListNode * res = addTwoNumbers.addTwoNumbers1(num1, num2);
	EXPECT_EQ(7, res->val);
	EXPECT_EQ(0, res->next->val);
	EXPECT_EQ(8, res->next->next->val);
}