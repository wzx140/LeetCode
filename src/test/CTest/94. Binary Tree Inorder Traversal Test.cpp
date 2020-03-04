#include "gtest/gtest.h"
#include "../../main/c++/header/BTIT.h"

class BTITTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data = { 1,0.5,2,3 };
		source = buildTree(data);
		res = { 1,3,2 };
	}

	void TearDown() override {}

	TreeNode* source;
	vector<int> res;
};

TEST_F(BTITTest, inorderTraversal1Test) {

	BTIT solution;
	EXPECT_EQ(res, solution.inorderTraversal1(source));
}

TEST_F(BTITTest, inorderTraversal2Test) {

	BTIT solution;
	EXPECT_EQ(res, solution.inorderTraversal2(source));
}