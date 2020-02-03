#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

class ContainerWithMostWaterTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 1,8,6,2,5,4,8,3,7 };
	}

	void TearDown() override {}

	vector<int> source;
};

TEST_F(ContainerWithMostWaterTest, maxArea1Test) {
	ContainerWithMostWater solution;
	EXPECT_EQ(49, solution.maxArea1(this->source));
}

TEST_F(ContainerWithMostWaterTest, maxArea2Test) {
	ContainerWithMostWater solution;
	EXPECT_EQ(49, solution.maxArea2(this->source));
}