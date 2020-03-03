#include "gtest/gtest.h"
#include "../../main/c++/header/BTPT.h"

class BTPTTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data = { 1,0.5,2,3 };
		source = buildTree(data);
		res = { 1,2,3 };
	}

	void TearDown() override {}

	TreeNode* source;
	vector<int> res;
};

TEST_F(BTPTTest, preorderTraversal1Test) {

	BTPT solution;
	EXPECT_EQ(res, solution.preorderTraversal1(source));
}

TEST_F(BTPTTest, preorderTraversal2Test) {

	BTPT solution;
	EXPECT_EQ(res, solution.preorderTraversal2(source));
}