#include "gtest/gtest.h"
#include "../../main/c++/header/BTBSS5.h"

class BTBSS5Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 1,2,3,0,2 };
	}

	void TearDown() override {}

	vector<int> source1;
};

TEST_F(BTBSS5Test, maxProfit1Test) {
	BTBSS5 solution;
	EXPECT_EQ(3, solution.maxProfit1(source1));
}

TEST_F(BTBSS5Test, maxProfit2Test) {
	BTBSS5 solution;
	EXPECT_EQ(3, solution.maxProfit2(source1));
}