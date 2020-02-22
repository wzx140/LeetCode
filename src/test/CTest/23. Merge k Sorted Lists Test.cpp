#include "gtest/gtest.h"
#include "../../main/c++/header/MergeKSortedLists.h"
#include "../../main/c++/header/Utill.h"

class MergeKSortedListsTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<int> list11{ 1,4,5 };
		vector<int> list12{ 1,3,4 };
		vector<int> list13{ 2,6 };
		list1.push_back(buildNodeList(list11));
		list1.push_back(buildNodeList(list12));
		list1.push_back(buildNodeList(list13));
		answer1 = { 1,1,2,3,4,4,5,6 };

		vector<int> list21{ -6, -3, -1, 1, 2, 2, 2 };
		vector<int> list22{ -10, -8, -6, -2, 4 };
		vector<int> list23{ -2 };
		vector<int> list24{ -8, -4, -3, -3, -2, -1, 1, 2, 3 };
		vector<int> list25{ -8, -6, -5, -4, -2, -2, 2, 4 };
		list2.push_back(buildNodeList(list21));
		list2.push_back(buildNodeList(list22));
		list2.push_back(buildNodeList(list23));
		list2.push_back(buildNodeList(list24));
		list2.push_back(buildNodeList(list25));
		answer2 = { -10,-8,-8,-8,-6,-6,-6,-5,-4,-4,-3,-3,-3,-2,-2,-2,-2,-2,-1,-1,1,1,2,2,2,2,2,3,4,4 };
	}

	void TearDown() override {}
	vector<ListNode*> list1;
	vector<ListNode*> list2;
	vector<int> answer1;
	vector<int> answer2;
};

TEST_F(MergeKSortedListsTest, mergeKLists1Test) {

	MergeKSortedLists solution;
	ListNode* res1 = solution.mergeKLists1(list1);
	EXPECT_EQ(answer1, decompositeNodeList(res1));
	ListNode* res2 = solution.mergeKLists1(list2);
	EXPECT_EQ(answer2, decompositeNodeList(res2));
}
