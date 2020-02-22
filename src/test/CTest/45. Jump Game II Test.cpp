#include "gtest/gtest.h"
#include "../../main/c++/header/JumpGame2.h"

class JumpGame2Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 2,3,1,1,4 };
		source2 = { 1, 2, 1, 1, 1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
};

TEST_F(JumpGame2Test, jump1Test) {

	JumpGame2 solution;
	EXPECT_EQ(2, solution.jump1(source1));
	EXPECT_EQ(3, solution.jump1(source2));
}

TEST_F(JumpGame2Test, jump2Test) {

	JumpGame2 solution;
	EXPECT_EQ(2, solution.jump2(source1));
	EXPECT_EQ(3, solution.jump2(source2));
}
