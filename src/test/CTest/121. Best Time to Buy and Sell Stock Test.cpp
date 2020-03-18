#include "gtest/gtest.h"
#include "../../main/c++/header/BTBSS1.h"

class BTBSS1Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 7,1,5,3,6,4 };
		source2 = { 7,6,4,3,1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
};

TEST_F(BTBSS1Test, maxProfit1Test) {
	BTBSS1 solution;
	EXPECT_EQ(5, solution.maxProfit1(source1));
	EXPECT_EQ(0, solution.maxProfit1(source2));
}

TEST_F(BTBSS1Test, maxProfit2Test) {
	BTBSS1 solution;
	EXPECT_EQ(5, solution.maxProfit2(source1));
	EXPECT_EQ(0, solution.maxProfit2(source2));
}