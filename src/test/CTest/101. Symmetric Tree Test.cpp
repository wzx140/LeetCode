#include "gtest/gtest.h"
#include "../../main/c++/header/SymmetricTree.h"

class SymmetricTreeTest : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data1 = { 1,2,2,3,4,4,3 };
		vector<float> data2 = { 1,2,2,0.5,3,0.5,3 };
		source1 = buildTree(data1);
		source2 = buildTree(data2);
	}

	void TearDown() override {}

	TreeNode* source1;
	TreeNode* source2;
};

TEST_F(SymmetricTreeTest, isSymmetric1Test) {

	SymmetricTree solution;
	EXPECT_TRUE(solution.isSymmetric1(source1));
	EXPECT_FALSE(solution.isSymmetric1(source2));
}
