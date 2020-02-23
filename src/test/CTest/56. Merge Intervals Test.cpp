#include "gtest/gtest.h"
#include "../../main/c++/header/MergeIntervals.h"

class MergeIntervalsTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		res1 = {{1, 6}, {8, 10}, {15, 18}};
		source2 = {{1, 4}, {4, 5}};
		res2 = {{1, 5}};
	}

	void TearDown() override {}

	vector<vector<int>> source1;
	vector<vector<int>> res1;
	vector<vector<int>> source2;
	vector<vector<int>> res2;
};

TEST_F(MergeIntervalsTest, merge1Test) {

	MergeIntervals solution;
	EXPECT_EQ(res1,solution.merge1(source1));
	EXPECT_EQ(res2, solution.merge1(source2));
}
