#include "gtest/gtest.h"
#include "../../main/c++/header/BTBSS2.h"

class BTBSS2Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 7,1,5,3,6,4 };
		source2 = { 1,2,3,4,5 };
		source3 = { 7,6,4,3,1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
	vector<int> source3;
};

TEST_F(BTBSS2Test, maxProfit1Test) {
	BTBSS2 solution;
	EXPECT_EQ(7, solution.maxProfit1(source1));
	EXPECT_EQ(4, solution.maxProfit1(source2));
	EXPECT_EQ(0, solution.maxProfit1(source3));
}

TEST_F(BTBSS2Test, maxProfit2Test) {
	BTBSS2 solution;
	EXPECT_EQ(7, solution.maxProfit2(source1));
	EXPECT_EQ(4, solution.maxProfit2(source2));
	EXPECT_EQ(0, solution.maxProfit2(source3));
}