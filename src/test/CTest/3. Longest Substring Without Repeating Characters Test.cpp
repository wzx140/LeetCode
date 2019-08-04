#include "pch.h"
#include "../../main/c++/Header.h"

class LongestSubstringWithoutRepeatingCharactersTest : public ::testing::Test {
protected:
	void SetUp() override {
	}

	void TearDown() override {
	}
};

TEST_F(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring1Test) {
	LongestSubstringWithoutRepeatingCharacters solution = LongestSubstringWithoutRepeatingCharacters();
	EXPECT_EQ(6, solution.lengthOfLongestSubstring1("abcabckfdca"));
	EXPECT_EQ(1, solution.lengthOfLongestSubstring1("bbbbb"));
	EXPECT_EQ(3, solution.lengthOfLongestSubstring1("pwwkew"));
	EXPECT_EQ(1, solution.lengthOfLongestSubstring1(" "));
	EXPECT_EQ(3, solution.lengthOfLongestSubstring1("dvdf"));
}

TEST_F(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring2Test) {
	LongestSubstringWithoutRepeatingCharacters solution = LongestSubstringWithoutRepeatingCharacters();
	EXPECT_EQ(6, solution.lengthOfLongestSubstring2("abcabckfdca"));
	EXPECT_EQ(1, solution.lengthOfLongestSubstring2("bbbbb"));
	EXPECT_EQ(3, solution.lengthOfLongestSubstring2("pwwkew"));
	EXPECT_EQ(1, solution.lengthOfLongestSubstring2(" "));
	EXPECT_EQ(3, solution.lengthOfLongestSubstring2("dvdf"));
}

TEST_F(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring3Test) {
	LongestSubstringWithoutRepeatingCharacters solution = LongestSubstringWithoutRepeatingCharacters();
	EXPECT_EQ(6, solution.lengthOfLongestSubstring3("abcabckfdca"));
	EXPECT_EQ(1, solution.lengthOfLongestSubstring3("bbbbb"));
	EXPECT_EQ(3, solution.lengthOfLongestSubstring3("pwwkew"));
	EXPECT_EQ(1, solution.lengthOfLongestSubstring3(" "));
	EXPECT_EQ(3, solution.lengthOfLongestSubstring3("dvdf"));
}