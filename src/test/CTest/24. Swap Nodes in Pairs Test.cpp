#include "pch.h"
#include "../../main/c++/Header.h"

class SNPTest : public ::testing::Test {
protected:
	void SetUp() override {
		this->nodes = new ListNode(1);
		this->nodes->next = new ListNode(2);
		this->nodes->next->next = new ListNode(3);
		this->nodes->next->next->next = new ListNode(4);
	}

	void TearDown() override {}

	ListNode* nodes;
};

TEST_F(SNPTest, swapPairs1Test) {
	SNP solution = SNP();
	ListNode* head = solution.swapPairs1(this->nodes);

	EXPECT_EQ(2, head->val);
	EXPECT_EQ(1, head->next->val);
	EXPECT_EQ(4, head->next->next->val);
	EXPECT_EQ(3, head->next->next->next->val);
}

TEST_F(SNPTest, swapPairs2Test) {
	SNP solution = SNP();
	ListNode* head = solution.swapPairs2(this->nodes);

	EXPECT_EQ(2, head->val);
	EXPECT_EQ(1, head->next->val);
	EXPECT_EQ(4, head->next->next->val);
	EXPECT_EQ(3, head->next->next->next->val);
}