#include "gtest/gtest.h"
#include "../../main/c++/header/BTOT.h"

class BTOTTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data = { 1,0.5,2,3 };
		source = buildTree(data);
		res = { 3,2,1 };
	}

	void TearDown() override {}

	TreeNode* source;
	vector<int> res;
};

TEST_F(BTOTTest, postorderTraversal1Test) {

	BTOT solution;
	EXPECT_EQ(res, solution.postorderTraversal1(source));
}

TEST_F(BTOTTest, postorderTraversal2Test) {

	BTOT solution;
	EXPECT_EQ(res, solution.postorderTraversal2(source));
}