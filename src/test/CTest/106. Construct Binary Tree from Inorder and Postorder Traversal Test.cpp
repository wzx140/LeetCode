#include "gtest/gtest.h"
#include "../../main/c++/header/CBTIP.h"

#include "../../main/c++/header/Util.h"

class CBTIPTest : public ::testing::Test {
protected:
	void SetUp() override {
		inorder = { 9,3,15,20,7 };
		postorder = { 9,15,7,20,3 };
		vector<float> data = { 3,9,20,0.5,0.5,15,7 };
		root = buildTree(data);
	}

	void TearDown() override {}

	vector<int> inorder;
	vector<int> postorder;
	TreeNode* root;
};

TEST_F(CBTIPTest, buildTree1Test) {

	CBTIP solution;
	TreeNode* res = solution.buildTree1(inorder, postorder);
	EXPECT_TRUE(treeEquals(root, res));
}