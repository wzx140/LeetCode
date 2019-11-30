#include "pch.h"
#include "../../main/c++/Header.h"

class SortArrayTest : public ::testing::Test {
protected:
	void SetUp() override {
		this->source1 = { 5,2,3,1 };
		this->source2 = { 5,1,1,2,0,0 };
		this->res1 = { 1,2,3,5 };
		this->res2 = { 0,0,1,1,2,5 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
	vector<int> res1;
	vector<int> res2;
};

TEST_F(SortArrayTest, sortArray1Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray1(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray1(this->source2));
}

TEST_F(SortArrayTest, sortArray2Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray2(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray2(this->source2));
}

TEST_F(SortArrayTest, sortArray3Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray3(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray3(this->source2));
}

TEST_F(SortArrayTest, sortArray4Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray4(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray4(this->source2));
}

TEST_F(SortArrayTest, sortArray5Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray5(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray5(this->source2));
}

TEST_F(SortArrayTest, sortArray6Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray6(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray6(this->source2));
}

TEST_F(SortArrayTest, sortArray7Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray7(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray7(this->source2));
}

TEST_F(SortArrayTest, sortArray8Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray8(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray8(this->source2));
}

TEST_F(SortArrayTest, sortArray9Test) {
	SortArray solution = SortArray();
	EXPECT_EQ(this->res1, solution.sortArray9(this->source1));
	EXPECT_EQ(this->res2, solution.sortArray9(this->source2));
}