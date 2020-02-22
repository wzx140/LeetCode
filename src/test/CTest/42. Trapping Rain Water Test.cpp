#include "gtest/gtest.h"
#include "../../main/c++/header/TrappingRainWater.h"

class TrappingRainWaterTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 0,1,0,2,1,0,1,3,2,1,2,1 };
		source2 = { 5,2,1,2,1,5 };
		source3 = { 4,2,3 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
	vector<int> source3;
};

TEST_F(TrappingRainWaterTest, trap1Test) {

	TrappingRainWater solution;
	EXPECT_EQ(6, solution.trap1(source1));
	EXPECT_EQ(14, solution.trap1(source2));
	EXPECT_EQ(1, solution.trap1(source3));
}

TEST_F(TrappingRainWaterTest, trap2Test) {

	TrappingRainWater solution;
	EXPECT_EQ(6, solution.trap2(source1));
	EXPECT_EQ(14, solution.trap2(source2));
	EXPECT_EQ(1, solution.trap2(source3));
}

TEST_F(TrappingRainWaterTest, trap3Test) {

	TrappingRainWater solution;
	EXPECT_EQ(6, solution.trap3(source1));
	EXPECT_EQ(14, solution.trap3(source2));
	EXPECT_EQ(1, solution.trap3(source3));
}
