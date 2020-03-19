#include "gtest/gtest.h"
#include "../../main/c++/header/HouseRobber2.h"

class HouseRobber2Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 2,3,2 };
		source2 = { 1,2,3,1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
};

TEST_F(HouseRobber2Test, rob1Test) {
	HouseRobber2 solution;
	EXPECT_EQ(3, solution.rob1(source1));
	EXPECT_EQ(4, solution.rob1(source2));
}

TEST_F(HouseRobber2Test, rob2Test) {
	HouseRobber2 solution;
	EXPECT_EQ(3, solution.rob2(source1));
	EXPECT_EQ(4, solution.rob2(source2));
}