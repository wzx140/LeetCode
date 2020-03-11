#include "gtest/gtest.h"
#include "../../main/c++/header/CBTPI.h"

#include "../../main/c++/header/Util.h"

class CBTPITest : public ::testing::Test {
protected:
	void SetUp() override {
		preorder = { 3,9,20,15,7 };
		inorder = { 9,3,15,20,7 };
		vector<float> data = { 3,9,20,0.5,0.5,15,7 };
		root = buildTree(data);
	}

	void TearDown() override {}

	vector<int> preorder;
	vector<int> inorder;
	TreeNode* root;
};

TEST_F(CBTPITest, buildTree1Test) {

	CBTPI solution;
	TreeNode* res = solution.buildTree1(preorder, inorder);
	EXPECT_TRUE(treeEquals(root, res));
}