#include "pch.h"
#include "../../main/c++/Header.h"

class IntegerToRomanTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(IntegerToRomanTest, intToRoman1Test) {
	IntegerToRoman solution;
	EXPECT_STREQ("III", solution.intToRoman1(3).c_str());
	EXPECT_STREQ("IV", solution.intToRoman1(4).c_str());
	EXPECT_STREQ("IX", solution.intToRoman1(9).c_str());
	EXPECT_STREQ("LVIII", solution.intToRoman1(58).c_str());
	EXPECT_STREQ("MCMXCIV", solution.intToRoman1(1994).c_str());
}

TEST_F(IntegerToRomanTest, intToRoman2Test) {
	IntegerToRoman solution;
	EXPECT_STREQ("III", solution.intToRoman2(3).c_str());
	EXPECT_STREQ("IV", solution.intToRoman2(4).c_str());
	EXPECT_STREQ("IX", solution.intToRoman2(9).c_str());
	EXPECT_STREQ("LVIII", solution.intToRoman2(58).c_str());
	EXPECT_STREQ("MCMXCIV", solution.intToRoman2(1994).c_str());
}