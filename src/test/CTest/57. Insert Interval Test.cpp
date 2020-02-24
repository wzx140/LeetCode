#include "gtest/gtest.h"
#include "../../main/c++/header/InsertInterval.h"

class InsertIntervalTest : public ::testing::Test {
protected:
	void SetUp() override {
		intervals1 = { {1, 3}, {6, 9} };
		newInterval1 = { 2, 5 };
		res1 = { {1, 5}, {6,9} };
		intervals2 = { {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16} };
		newInterval2 = { 4, 8 };
		res2 = { {1, 2}, {3, 10}, {12, 16} };
		intervals3 = { {1,5} };
		newInterval3 = { 6,8 };
		res3 = { {1, 5}, {6,8} };
		intervals4 = { {1,5} };
		newInterval4 = { 0,3 };
		res4 = { {0, 5} };
	}

	void TearDown() override {}

	vector<vector<int>> intervals1;
	vector<int> newInterval1;
	vector<vector<int>> res1;
	vector<vector<int>> intervals2;
	vector<int> newInterval2;
	vector<vector<int>> res2;
	vector<vector<int>> intervals3;
	vector<int> newInterval3;
	vector<vector<int>> res3;
	vector<vector<int>> intervals4;
	vector<int> newInterval4;
	vector<vector<int>> res4;
};

TEST_F(InsertIntervalTest, insert1Test) {

	InsertInterval solution;
	EXPECT_EQ(res1, solution.insert1(intervals1, newInterval1));
	EXPECT_EQ(res2, solution.insert1(intervals2, newInterval2));
	EXPECT_EQ(res3, solution.insert1(intervals3, newInterval3));
	EXPECT_EQ(res4, solution.insert1(intervals4, newInterval4));
}