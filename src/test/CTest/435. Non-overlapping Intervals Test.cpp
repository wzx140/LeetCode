#include "gtest/gtest.h"
#include "../../main/c++/header/NonOverlappingIntervals.h"

class NonOverlappingIntervalsTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
		source2 = {{1, 2}, {1, 2}, {1, 2}};
		source3 = {{1, 2}, {2, 3}};
	}

	void TearDown() override {}

	vector<vector<int>> source1;
	vector<vector<int>> source2;
	vector<vector<int>> source3;
};

TEST_F(NonOverlappingIntervalsTest, eraseOverlapIntervals1Test) {

	NonOverlappingIntervals solution;
	EXPECT_EQ(1, solution.eraseOverlapIntervals1(source1));
	EXPECT_EQ(2, solution.eraseOverlapIntervals1(source2));
	EXPECT_EQ(0, solution.eraseOverlapIntervals1(source3));
}
