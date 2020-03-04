#include "gtest/gtest.h"
#include "../../main/c++/header/MTSL.h"
#include "../../main/c++/header/Util.h"

class MTSLTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<int> source1 = { 1,2,4 };
		vector<int> source2 = { 1,3,4 };
		list1 = buildNodeList(source1);
		list2 = buildNodeList(source2);
		answer = { 1,1,2,3,4,4 };
	}

	void TearDown() override {}
	ListNode* list1;
	ListNode* list2;
	vector<int> answer;
};

TEST_F(MTSLTest, mergeTwoLists1Test) {

	MTSL solution;
	ListNode * res = solution.mergeTwoLists1(list1, list2);
	EXPECT_EQ(answer,decompositeNodeList(res));
}

TEST_F(MTSLTest, mergeTwoLists2Test) {

	MTSL solution;
	ListNode * res = solution.mergeTwoLists2(list1, list2);
	EXPECT_EQ(answer, decompositeNodeList(res));
}
