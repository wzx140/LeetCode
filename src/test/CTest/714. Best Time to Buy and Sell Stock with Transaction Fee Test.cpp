#include "gtest/gtest.h"
#include "../../main/c++/header/BTBSS6.h"

class BTBSS6Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 1, 3, 2, 8, 4, 9 };
	}

	void TearDown() override {}

	vector<int> source1;
};

TEST_F(BTBSS6Test, maxProfit1Test) {
	BTBSS6 solution;
	EXPECT_EQ(8, solution.maxProfit1(source1,2));
}

TEST_F(BTBSS6Test, maxProfit2Test) {
	BTBSS6 solution;
	EXPECT_EQ(8, solution.maxProfit2(source1, 2));
}