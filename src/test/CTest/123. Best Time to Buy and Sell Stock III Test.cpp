#include "gtest/gtest.h"
#include "../../main/c++/header/BTBSS3.h"

class BTBSS3Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 3,3,5,0,0,3,1,4 };
		source2 = { 1,2,3,4,5 };
		source3 = { 7, 6, 4, 3, 1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
	vector<int> source3;
};

TEST_F(BTBSS3Test, maxProfit1Test) {
	BTBSS3 solution;
	EXPECT_EQ(6, solution.maxProfit1(source1));
	EXPECT_EQ(4, solution.maxProfit1(source2));
	EXPECT_EQ(0, solution.maxProfit1(source3));
}

TEST_F(BTBSS3Test, maxProfit2Test) {
	BTBSS3 solution;
	EXPECT_EQ(6, solution.maxProfit2(source1));
	EXPECT_EQ(4, solution.maxProfit2(source2));
	EXPECT_EQ(0, solution.maxProfit2(source3));
}