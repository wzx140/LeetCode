#include "gtest/gtest.h"
#include "../../main/c++/header/BalancedBinaryTree.h"

class BalancedBinaryTreeTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<float> data1 = { 3,9,20,0.5,0.5,15,7 };
		vector<float> data2 = { 1,2,2,3,3,0.5,0.5,4,4 };
		root1 = buildTree(data1);
		root2 = buildTree(data2);
	}

	void TearDown() override {}

	TreeNode* root1;
	TreeNode* root2;
};

TEST_F(BalancedBinaryTreeTest, isBalanced1Test) {

	BalancedBinaryTree solution;
	EXPECT_TRUE(solution.isBalanced1(root1));
	EXPECT_FALSE(solution.isBalanced1(root2));
}