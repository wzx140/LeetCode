#include "pch.h"
#include "../../main/c++/Header.h"

class SNPTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<int> source{1,2,3,4};
		nodes = buildNodeList(source);
		answer = { 2,1,4,3 };
	}

	void TearDown() override {}

	ListNode* nodes;
	vector<int> answer;
};

TEST_F(SNPTest, swapPairs1Test) {
	SNP solution = SNP();
	ListNode* head = solution.swapPairs1(this->nodes);
	EXPECT_EQ(answer, decompositeNodeList(head));
}

TEST_F(SNPTest, swapPairs2Test) {
	SNP solution = SNP();
	ListNode* head = solution.swapPairs2(this->nodes);
	EXPECT_EQ(answer, decompositeNodeList(head));
}