#include "gtest/gtest.h"
#include "../../main/c++/header/MedianOfTwoSortedArrays.h"

class MedianOfTwoSortedArraysTest : public ::testing::Test{
protected:
	void SetUp() override{
	}

	void TearDown() override{
	}
};

TEST_F(MedianOfTwoSortedArraysTest, findMedianSortedArrays1Test){
	int vb1[] = {1, 2, 3, 4, 5};
	int va2[] = {1, 3};
	int vb2[] = {2};
	MedianOfTwoSortedArrays solution;
	EXPECT_EQ(3.0, solution.findMedianSortedArrays1(std::vector<int>(), std::vector<int>(vb1, vb1 + 5)));
	EXPECT_EQ(2.0, solution.findMedianSortedArrays1(std::vector<int>(va2, va2 + 2), std::vector<int>(vb2, vb2 + 1)));
}

TEST_F(MedianOfTwoSortedArraysTest, findMedianSortedArrays2Test){
	int vb1[] = {1, 2, 3, 4, 5};
	int va2[] = {1, 3};
	int vb2[] = {2};
	std::vector<int> va3 = {3};
	std::vector<int> vb3 = {-2,1 };
	MedianOfTwoSortedArrays solution;
	EXPECT_EQ(3.0, solution.findMedianSortedArrays2(std::vector<int>(), std::vector<int>(vb1, vb1 + 5)));
	EXPECT_EQ(2.0, solution.findMedianSortedArrays2(std::vector<int>(va2, va2 + 2), std::vector<int>(vb2, vb2 + 1)));
	EXPECT_EQ(1.0, solution.findMedianSortedArrays2(va3, vb3));
}
