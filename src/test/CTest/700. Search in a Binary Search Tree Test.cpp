#include "gtest/gtest.h"
#include "../../main/c++/header/SearchBST.h"

class SearchBSTTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data1 = { 4,2,7,1,3 };
		vector<float> data2 = { 2,1,3 };
		source = buildTree(data1);
		res = buildTree(data2);
	}

	void TearDown() override {}

	TreeNode* source;
	TreeNode* res;
};

TEST_F(SearchBSTTest, searchBST1Test) {

	SearchBST solution;
	EXPECT_TRUE(treeEquals(res, solution.searchBST1(source, 2)));
	EXPECT_EQ(NULL, solution.searchBST1(res, 5));
}
