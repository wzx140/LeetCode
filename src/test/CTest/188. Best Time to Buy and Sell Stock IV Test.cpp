#include "gtest/gtest.h"
#include "../../main/c++/header/BTBSS4.h"

class BTBSS4Test : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 2,1,4 };
		source2 = { 3,2,6,5,0,3 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
};

TEST_F(BTBSS4Test, maxProfit1Test) {
	BTBSS4 solution;
	EXPECT_EQ(3, solution.maxProfit1(2, source1));
	EXPECT_EQ(7, solution.maxProfit1(2, source2));
}