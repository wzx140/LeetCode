#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

#include <algorithm>

using std::sort;

class SpiralMatrixTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { {1, 2, 3},
					{4, 5, 6},
					{7, 8, 9} };
		res1 = { 1,2,3,6,9,8,7,4,5 };
		source2 = {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9,10,11,12}};
		res2 = { 1,2,3,4,8,12,11,10,9,5,6,7 };
	}

	void TearDown() override {}

	vector<vector<int>> source1;
	vector<int> res1;
	vector<vector<int>> source2;
	vector<int> res2;
};

TEST_F(SpiralMatrixTest, spiralOrder1Test) {

	SpiralMatrix solution;
	EXPECT_EQ(res1, solution.spiralOrder1(source1));
	EXPECT_EQ(res2, solution.spiralOrder1(source2));
}

TEST_F(SpiralMatrixTest, spiralOrder2Test) {

	SpiralMatrix solution;
	EXPECT_EQ(res1, solution.spiralOrder2(source1));
	EXPECT_EQ(res2, solution.spiralOrder2(source2));
}