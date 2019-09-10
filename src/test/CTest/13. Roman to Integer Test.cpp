#include "pch.h"
#include "../../main/c++/Header.h"

class RomanToIntegerTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(RomanToIntegerTest, romanToIntTest) {
	RomanToInteger solution;
	EXPECT_EQ(3, solution.romanToInt("III"));
	EXPECT_EQ(4, solution.romanToInt("IV"));
	EXPECT_EQ(9, solution.romanToInt("IX"));
	EXPECT_EQ(58, solution.romanToInt("LVIII"));
	EXPECT_EQ(1994, solution.romanToInt("MCMXCIV"));
}