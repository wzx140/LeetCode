#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

class SearchInsertPositionTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 1,3,5,6 };
	}

	void TearDown() override {}

	vector<int> source;
};

TEST_F(SearchInsertPositionTest, searchInsert1Test) {

	SearchInsertPosition solution = SearchInsertPosition();
	EXPECT_EQ(2, solution.searchInsert1(source, 5));
	EXPECT_EQ(1, solution.searchInsert1(source, 2));
	EXPECT_EQ(4, solution.searchInsert1(source, 7));
	EXPECT_EQ(0, solution.searchInsert1(source, 0));
}