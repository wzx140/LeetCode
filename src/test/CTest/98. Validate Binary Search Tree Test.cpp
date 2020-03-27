#include "gtest/gtest.h"
#include "../../main/c++/header/ValidateBST.h"

class ValidateBSTTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<float> data1 = { 2,1,3 };
		vector<float> data2 = { 5,1,4,0.5,0.5,3,6 };
		root1 = buildTree(data1);
		root2 = buildTree(data2);
	}

	void TearDown() override {}

	TreeNode* root1;
	TreeNode* root2;
};

TEST_F(ValidateBSTTest, isValidBST1Test) {

	ValidateBST solution;
	EXPECT_TRUE(solution.isValidBST1(root1));
	EXPECT_FALSE(solution.isValidBST1(root2));
}