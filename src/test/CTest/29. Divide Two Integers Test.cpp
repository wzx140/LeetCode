#include "gtest/gtest.h"
#include "../../main/c++/header/DivideTwoIntegers.h"

class DivideTwoIntegersTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(DivideTwoIntegersTest, divide1Test) {

	DivideTwoIntegers solution;
	EXPECT_EQ(3, solution.divide1(10, 3));
	EXPECT_EQ(-2, solution.divide1(7, -3));
}

TEST_F(DivideTwoIntegersTest, divide2Test) {

	DivideTwoIntegers solution;
	EXPECT_EQ(3, solution.divide2(10, 3));
	EXPECT_EQ(-2, solution.divide2(7, -3));
}

TEST_F(DivideTwoIntegersTest, divide3Test) {

	DivideTwoIntegers solution;
	EXPECT_EQ(3, solution.divide3(10, 3));
	EXPECT_EQ(-2, solution.divide3(7, -3));
}
