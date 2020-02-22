#include "gtest/gtest.h"
#include "../../main/c++/header/JumpGame.h"

class JumpGameTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 2,3,1,1,4 };
		source2 = { 3,2,1,0,4 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
};

TEST_F(JumpGameTest, canJump1Test) {

	JumpGame solution;
	EXPECT_TRUE(solution.canJump1(source1));
	EXPECT_FALSE(solution.canJump1(source2));
}

TEST_F(JumpGameTest, canJump2Test) {

	JumpGame solution;
	EXPECT_TRUE(solution.canJump2(source1));
	EXPECT_FALSE(solution.canJump2(source2));
}

TEST_F(JumpGameTest, canJump3Test) {

	JumpGame solution;
	EXPECT_TRUE(solution.canJump3(source1));
	EXPECT_FALSE(solution.canJump3(source2));
}
