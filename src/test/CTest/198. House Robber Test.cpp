#include "gtest/gtest.h"
#include "../../main/c++/header/HouseRobber.h"

class HouseRobberTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 1,2,3,1 };
		source2 = { 2,7,9,3,1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
};

TEST_F(HouseRobberTest, rob1Test) {
	HouseRobber solution;
	EXPECT_EQ(4, solution.rob1(source1));
	EXPECT_EQ(12, solution.rob1(source2));
}

TEST_F(HouseRobberTest, rob2Test) {
	HouseRobber solution;
	EXPECT_EQ(4, solution.rob2(source1));
	EXPECT_EQ(12, solution.rob2(source2));
}