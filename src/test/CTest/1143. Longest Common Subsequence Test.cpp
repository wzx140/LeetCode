#include "gtest/gtest.h"
#include "../../main/c++/header/LongestCommonSubsequence.h"

class LongestCommonSubsequenceTest : public ::testing::Test {
protected:
	void SetUp() override {
		source11 = "abcde";
		source12 = "ace";
		source21 = "abc";
		source22 = "abc";
		source31 = "abc";
		source32 = "def";
	}

	void TearDown() override {}

	string source11;
	string source12;
	string source21;
	string source22;
	string source31;
	string source32;
};

TEST_F(LongestCommonSubsequenceTest, minDistance1Test) {

	LongestCommonSubsequence solution;
	EXPECT_EQ(3, solution.longestCommonSubsequence1(source11, source12));
	EXPECT_EQ(3, solution.longestCommonSubsequence1(source21, source22));
	EXPECT_EQ(0, solution.longestCommonSubsequence1(source31, source32));
}

TEST_F(LongestCommonSubsequenceTest, minDistance2Test) {

	LongestCommonSubsequence solution;
	EXPECT_EQ(3, solution.longestCommonSubsequence2(source11, source12));
	EXPECT_EQ(3, solution.longestCommonSubsequence2(source21, source22));
	EXPECT_EQ(0, solution.longestCommonSubsequence2(source31, source32));
}