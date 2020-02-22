#include "gtest/gtest.h"
#include "../../main/c++/header/CombinationSum.h"

class CombinationSumTest : public ::testing::Test {
protected:
	void SetUp() override {
		candidates1 = { 6,7,2,3 };
		candidates2 = { 2,3,5 };
		solution1 = { {2,2,3},{7} };
		solution2 = { {2,2,2,2},{2,3,3},{3,5} };
	}

	void TearDown() override {}

	vector<int> candidates1;
	vector<int> candidates2;
	vector<vector<int>> solution1;
	vector<vector<int>> solution2;
};

TEST_F(CombinationSumTest, combinationSum1Test) {

	CombinationSum solution;
	EXPECT_EQ(solution1, solution.combinationSum1(candidates1, 7));
	EXPECT_EQ(solution2, solution.combinationSum1(candidates2, 8));
}
