#include "gtest/gtest.h"
#include "../../main/c++/header/CCTN.h"

class CCTNTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<float> data = { 1,2,3,4,5,6,0.5 };
		root = buildTree(data);
	}

	void TearDown() override {}

	TreeNode* root;
};

TEST_F(CCTNTest, countNodes1Test) {

	CCTN solution;
	EXPECT_EQ(6, solution.countNodes1(root));
}