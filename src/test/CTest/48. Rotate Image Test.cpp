#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

#include <algorithm>

using std::sort;

class RotateImageTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { {1,2,3},{4,5,6},{7,8,9} };
		source2 = { {5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16} };
		res1 = { {7,4,1},{8,5,2},{9,6,3} };
		res2 = { {15,13, 2, 5},{14, 3, 4, 1},{12, 6, 8, 9},{16, 7,10,11} };
	}

	void TearDown() override {}

	vector<vector<int>> source1;
	vector<vector<int>> source2;
	vector<vector<int>> res1;
	vector<vector<int>> res2;
};

TEST_F(RotateImageTest, rotate1Test) {

	RotateImage solution;
	solution.rotate1(source1);
	EXPECT_EQ(res1, source1);	
	solution.rotate1(source2);
	EXPECT_EQ(res2, source2);
}

TEST_F(RotateImageTest, rotate2Test) {

	RotateImage solution;
	solution.rotate2(source1);
	EXPECT_EQ(res1, source1);
	solution.rotate2(source2);
	EXPECT_EQ(res2, source2);
}

TEST_F(RotateImageTest, rotate3Test) {

	RotateImage solution;
	solution.rotate2(source1);
	EXPECT_EQ(res1, source1);
	solution.rotate2(source2);
	EXPECT_EQ(res2, source2);
}