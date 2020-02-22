#include "gtest/gtest.h"
#include "../../main/c++/header/CombinationSum2.h"

class CombinationSum2Test : public ::testing::Test {
protected:
	void SetUp() override {
		candidates1 = { 10,1,2,7,6,1,5 };
		candidates2 = { 2,5,2,1,2 };
		solution1 = { {1, 1, 6} ,{1, 2, 5},{1, 7} ,{2, 6} };
		solution2 = { {1,2,2},{5} };
	}

	void TearDown() override {}

	vector<int> candidates1;
	vector<int> candidates2;
	vector<vector<int>> solution1;
	vector<vector<int>> solution2;
};

TEST_F(CombinationSum2Test, combinationSum1Test) {

	CombinationSum2 solution;
	EXPECT_EQ(solution1, solution.combinationSum1(candidates1, 8));
	EXPECT_EQ(solution2, solution.combinationSum1(candidates2, 5));
}
