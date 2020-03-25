#include "gtest/gtest.h"
#include "../../main/c++/header/MinDBT.h"

class MinDBTTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<float> data = { 3,9,20,0.5,0.5,15,7 };
		root = buildTree(data);
	}

	void TearDown() override {}

	TreeNode* root;
};

TEST_F(MinDBTTest, minDepth1Test) {

	MinDBT solution;
	EXPECT_EQ(2, solution.minDepth1(root));
}