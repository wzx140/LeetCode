#include "pch.h"
#include "../../main/c++/Header.h"

class LongestPalindromicSubstringTest : public ::testing::Test {
protected:
	string a1 = "babad";
	string a2 = "bab";

	string b1 = "cbbd";
	string b2 = "bb";

	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(LongestPalindromicSubstringTest, longestPalindrome1Test) {

	LongestPalindromicSubstring solution = LongestPalindromicSubstring();
	EXPECT_STREQ(a2.c_str(), solution.longestPalindrome1(a1).c_str());
	EXPECT_STREQ(b2.c_str(), solution.longestPalindrome1(b1).c_str());
}

TEST_F(LongestPalindromicSubstringTest, longestPalindrome2Test) {
	LongestPalindromicSubstring solution = LongestPalindromicSubstring();
	EXPECT_STREQ(a2.c_str(), solution.longestPalindrome2(a1).c_str());
	EXPECT_STREQ(b2.c_str(), solution.longestPalindrome2(b1).c_str());
}

TEST_F(LongestPalindromicSubstringTest, longestPalindrome3Test) {
	LongestPalindromicSubstring solution = LongestPalindromicSubstring();
	EXPECT_STREQ(a2.c_str(), solution.longestPalindrome3(a1).c_str());
	EXPECT_STREQ(b2.c_str(), solution.longestPalindrome3(b1).c_str());
}

TEST_F(LongestPalindromicSubstringTest, longestPalindrome4Test) {
	LongestPalindromicSubstring solution = LongestPalindromicSubstring();
	EXPECT_STREQ(a2.c_str(), solution.longestPalindrome4(a1).c_str());
	EXPECT_STREQ(b2.c_str(), solution.longestPalindrome4(b1).c_str());
}