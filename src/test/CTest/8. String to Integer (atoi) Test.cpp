#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

class AtoiTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(AtoiTest, myAtoi1Test) {
	Atoi solution = Atoi();
	EXPECT_EQ(42, solution.myAtoi1("42"));
	EXPECT_EQ(-42, solution.myAtoi1("   -42"));
	EXPECT_EQ(4193, solution.myAtoi1("4193 with words"));
	EXPECT_EQ(0, solution.myAtoi1("words and 987"));
	EXPECT_EQ(-2147483648, solution.myAtoi1("-91283472332"));
	EXPECT_EQ(-2147483648, solution.myAtoi1("-2147483648"));
}