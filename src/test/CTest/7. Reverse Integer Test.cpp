#include "gtest/gtest.h"
#include "../../main/c++/header/ReverseInteger.h"

class ReverseIntegerTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(ReverseIntegerTest, reverse1Test) {
	ReverseInteger solution;
	EXPECT_EQ(123, solution.reverse1(321));
	EXPECT_EQ(-321, solution.reverse1(-123));
	EXPECT_EQ(0, solution.reverse1(1534236469));
}

TEST_F(ReverseIntegerTest, reverse2Test) {
	ReverseInteger solution;
	EXPECT_EQ(123, solution.reverse2(321));
	EXPECT_EQ(-321, solution.reverse2(-123));
	EXPECT_EQ(0, solution.reverse2(1534236469));
}
