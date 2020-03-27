#include "gtest/gtest.h"
#include "../../main/c++/header/InsertBST.h"

class InsertBSTTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data1 = { 4,2,7,1,3 };
		vector<float> data2 = { 4,2,7,1,3,5 };
		vector<float> data3 = { 5,2,7,1,3,0.5,0.5,0.5,0.5,0.5,4 };
		source = buildTree(data1);
		res1 = buildTree(data2);
		res2 = buildTree(data3);
	}

	void TearDown() override {}

	TreeNode* source;
	TreeNode* res1;
	TreeNode* res2;
};

TEST_F(InsertBSTTest, insertIntoBST1Test) {

	InsertBST solution;
	auto node = solution.insertIntoBST1(source, 5);
	EXPECT_TRUE(treeEquals(res1, node) || treeEquals(res2, node));
}