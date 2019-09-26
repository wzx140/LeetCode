#include "pch.h"
#include "../../main/c++/Header.h"

class ValidParenthesesTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(ValidParenthesesTest, isValid1Test) {
	ValidParentheses solution = ValidParentheses();
	EXPECT_TRUE(solution.isValid1("()"));
	EXPECT_TRUE(solution.isValid1("()[]{}"));
	EXPECT_FALSE(solution.isValid1("(]"));
	EXPECT_FALSE(solution.isValid1("([)]"));
	EXPECT_TRUE(solution.isValid1("{[]}"));
}