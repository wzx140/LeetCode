#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

class FirstMissingPositiveTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 1,2,0 };
		source2 = { 3,4,-1,1 };
		source3 = { 7,8,9,11,12 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
	vector<int> source3;
};

TEST_F(FirstMissingPositiveTest, firstMissingPositive1Test) {

	FirstMissingPositive solution;
	EXPECT_EQ(3, solution.firstMissingPositive1(source1));
	EXPECT_EQ(2, solution.firstMissingPositive1(source2));
	EXPECT_EQ(1, solution.firstMissingPositive1(source3));
}

TEST_F(FirstMissingPositiveTest, firstMissingPositive2Test) {

	FirstMissingPositive solution;
	EXPECT_EQ(3, solution.firstMissingPositive2(source1));
	EXPECT_EQ(2, solution.firstMissingPositive2(source2));
	EXPECT_EQ(1, solution.firstMissingPositive2(source3));
}