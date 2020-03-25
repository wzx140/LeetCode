#include "gtest/gtest.h"
#include "../../main/c++/header/SameTree.h"

class SameTreeTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data11 = { 1,2,3 };
		vector<float> data12 = { 1,2,3 };
		vector<float> data21 = { 1,2 };
		vector<float> data22 = { 1,0.5,2 };
		vector<float> data31 = { 1,2,1};
		vector<float> data32 = { 1,1,2 };
		source11 = buildTree(data11);
		source12 = buildTree(data12);
		source21 = buildTree(data21);
		source22 = buildTree(data22);
		source31 = buildTree(data31);
		source32 = buildTree(data32);
	}

	void TearDown() override {}

	TreeNode* source11;
	TreeNode* source12;
	TreeNode* source21;
	TreeNode* source22;
	TreeNode* source31;
	TreeNode* source32;
};

TEST_F(SameTreeTest, isSameTree1Test) {

	SameTree solution;
	EXPECT_TRUE(solution.isSameTree1(source11, source12));
	EXPECT_FALSE(solution.isSameTree1(source21, source22));
	EXPECT_FALSE(solution.isSameTree1(source31, source32));
}
