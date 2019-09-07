#include "pch.h"
#include "../../main/c++/Header.h"

class PalindromeNumberTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(PalindromeNumberTest, isPalindrome1Test) {
	PalindromeNumber solution;
	EXPECT_TRUE(solution.isPalindrome1(121));
	EXPECT_FALSE(solution.isPalindrome1(-123));
	EXPECT_FALSE(solution.isPalindrome1(10));
}

TEST_F(PalindromeNumberTest, isPalindrome2Test) {
	PalindromeNumber solution;
	EXPECT_TRUE(solution.isPalindrome2(121));
	EXPECT_FALSE(solution.isPalindrome2(-123));
	EXPECT_FALSE(solution.isPalindrome2(10));
}

TEST_F(PalindromeNumberTest, isPalindrome3Test) {
	PalindromeNumber solution;
	EXPECT_TRUE(solution.isPalindrome3(121));
	EXPECT_FALSE(solution.isPalindrome3(-123));
	EXPECT_FALSE(solution.isPalindrome3(10));
}