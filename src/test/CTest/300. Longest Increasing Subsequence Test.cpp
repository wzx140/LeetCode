#include "gtest/gtest.h"
#include "../../main/c++/header/LongestIncreasingSubsequence.h"

class LongestIncreasingSubsequenceTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 10,9,2,5,3,7,101,18 };
	}

	void TearDown() override {}
	vector<int> source;
};

TEST_F(LongestIncreasingSubsequenceTest, lengthOfLIS1Test) {

	LongestIncreasingSubsequence solution;
	EXPECT_EQ(4, solution.lengthOfLIS1(source));
}
