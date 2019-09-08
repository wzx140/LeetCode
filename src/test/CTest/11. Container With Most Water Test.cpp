#include "pch.h"
#include "../../main/c++/Header.h"

class ContainerWithMostWaterTest : public ::testing::Test {
protected:
	void SetUp() override {
		this->source.push_back(1);
		this->source.push_back(8);
		this->source.push_back(6);
		this->source.push_back(2);
		this->source.push_back(5);
		this->source.push_back(4);
		this->source.push_back(8);
		this->source.push_back(3);
		this->source.push_back(7);
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