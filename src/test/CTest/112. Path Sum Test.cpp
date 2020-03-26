#include "gtest/gtest.h"
#include "../../main/c++/header/PathSum.h"

class PathSumTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<float> data = { 5,4,8,11,0.5,13,4,7,2,0.5,0.5,0.5,1 };
		root = buildTree(data);
	}

	void TearDown() override {}

	TreeNode* root;
};

TEST_F(PathSumTest, hasPathSum1Test) {

	PathSum solution;
	EXPECT_TRUE(solution.hasPathSum1(root, 22));
}