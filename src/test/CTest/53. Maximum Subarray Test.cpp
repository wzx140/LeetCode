#include "gtest/gtest.h"
#include "../../main/c++/header/MaximumSubarray.h"

#include <algorithm>

using std::sort;

class MaximumSubarrayTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { -2,1,-3,4,-1,2,1,-5,4 };
	}

	void TearDown() override {}

	vector<int> source;
};

TEST_F(MaximumSubarrayTest, maxSubArray1Test) {

	MaximumSubarray solution;
	EXPECT_EQ(6, solution.maxSubArray1(source));
}

TEST_F(MaximumSubarrayTest, maxSubArray2Test) {

	MaximumSubarray solution;
	EXPECT_EQ(6, solution.maxSubArray2(source));
}

TEST_F(MaximumSubarrayTest, maxSubArray3Test) {

	MaximumSubarray solution;
	EXPECT_EQ(6, solution.maxSubArray3(source));
}

TEST_F(MaximumSubarrayTest, maxSubArray4Test) {

	MaximumSubarray solution;
	EXPECT_EQ(6, solution.maxSubArray4(source));
}
