#include "gtest/gtest.h"
#include "../../main/c++/header/RNEL.h"
#include "../../main/c++/header/Util.h"

class RNELTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<int> source = { 1,2,3,4,5 };
		list = buildNodeList(source);
		answer = {1,2,3,5};
	}

	void TearDown() override {}
	ListNode* list;
	vector<int> answer;
};

TEST_F(RNELTest, removeNthFromEnd1Test) {

	RNEL solution;
	ListNode * res = solution.removeNthFromEnd1(list, 2);
	EXPECT_EQ(answer, decompositeNodeList(res));
}
