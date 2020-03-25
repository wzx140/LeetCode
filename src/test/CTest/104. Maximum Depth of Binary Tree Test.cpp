#include "gtest/gtest.h"
#include "../../main/c++/header/MDBT.h"

class MDBTTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<float> data = { 3,9,20,0.5,0.5,15,7 };
		root = buildTree(data);
	}

	void TearDown() override {}

	TreeNode* root;
};

TEST_F(MDBTTest, maxDepth1Test) {

	MDBT solution;
	EXPECT_EQ(3, solution.maxDepth1(root));
}