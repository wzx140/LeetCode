#include "gtest/gtest.h"
#include "../../main/c++/header/ValidParentheses.h"

class ValidParenthesesTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(ValidParenthesesTest, isValid1Test) {
	ValidParentheses solution;
	EXPECT_TRUE(solution.isValid1("()"));
	EXPECT_TRUE(solution.isValid1("()[]{}"));
	EXPECT_FALSE(solution.isValid1("(]"));
	EXPECT_FALSE(solution.isValid1("([)]"));
	EXPECT_TRUE(solution.isValid1("{[]}"));
}
