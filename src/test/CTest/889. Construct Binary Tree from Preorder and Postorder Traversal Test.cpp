#include "gtest/gtest.h"
#include "../../main/c++/header/CBTPP.h"

#include "../../main/c++/header/Util.h"

class CBTPPTest : public ::testing::Test {
protected:
	void SetUp() override {
		preorder = { 1,2,4,5,3,6,7 };
		postorder = { 4,5,2,6,7,3,1 };
		vector<float> data = { 1,2,3,4,5,6,7 };
		root = buildTree(data);
	}

	void TearDown() override {}

	vector<int> preorder;
	vector<int> postorder;
	TreeNode* root;
};

TEST_F(CBTPPTest, buildTree1Test) {

	CBTPP solution;
	auto res = solution.buildTree1(preorder, postorder);
	EXPECT_TRUE(treeEquals(root, res));
}