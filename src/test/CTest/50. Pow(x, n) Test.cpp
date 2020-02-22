#include "gtest/gtest.h"
#include "../../main/c++/header/MyPow.h"

class MyPowTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(MyPowTest, myPow1Test) {

	MyPow solution;
	EXPECT_EQ(1024.00000, solution.myPow1(2.00000, 10));
	EXPECT_EQ(0.25000, solution.myPow1(2.00000, -2));
}

TEST_F(MyPowTest, myPow2Test) {

	MyPow solution;
	EXPECT_EQ(1024.00000, solution.myPow2(2.00000, 10));
	EXPECT_EQ(0.25000, solution.myPow2(2.00000, -2));
}

TEST_F(MyPowTest, myPow3Test) {

	MyPow solution;
	EXPECT_EQ(1024.00000, solution.myPow3(2.00000, 10));
	EXPECT_EQ(0.25000, solution.myPow3(2.00000, -2));
}
