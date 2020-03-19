#include "gtest/gtest.h"
#include "../../main/c++/header/HouseRobber3.h"

class HouseRobber3Test : public ::testing::Test {
protected:
	void SetUp() override {
		// 用小数代替null
		vector<float> data = { 3,2,3,0.5,3,0.5,1 };
		source1 = buildTree(data);
		data = { 3,4,5,1,3,0.5,1 };
		source2 = buildTree(data);
	}

	void TearDown() override {}

	TreeNode* source1;
	TreeNode* source2;
};

TEST_F(HouseRobber3Test, rob1Test) {
	HouseRobber3 solution;
	EXPECT_EQ(7, solution.rob1(source1));
	EXPECT_EQ(9, solution.rob1(source2));
}