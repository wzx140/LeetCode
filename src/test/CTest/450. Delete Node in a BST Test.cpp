#include "gtest/gtest.h"
#include "../../main/c++/header/DeleteBST.h"

class DeleteBSTTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data1 = { 5,3,6,2,4,0.5,7 };
		vector<float> data2 = { 5,4,6,2,0.5,0.5,7 };
		vector<float> data3 = { 5,2,6,0.5,4,0.5,7 };
		source = buildTree(data1);
		res1 = buildTree(data2);
		res2 = buildTree(data3);
	}

	void TearDown() override {}

	TreeNode* source;
	TreeNode* res1;
	TreeNode* res2;
};

TEST_F(DeleteBSTTest, deleteNode1Test) {

	DeleteBST solution;
	auto node = solution.deleteNode1(source, 3);
	EXPECT_TRUE(treeEquals(res1, node) || treeEquals(res2, node));
}