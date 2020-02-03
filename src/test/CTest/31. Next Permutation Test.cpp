#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

class NextPermutationTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 1, 2, 3 };
		source2 = { 3, 2, 1 };
		source3 = { 1, 1, 5 };

		res1 = { 1, 3, 2 };
		res2 = { 1, 2, 3 };
		res3 = { 1, 5, 1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
	vector<int> source3;
	vector<int> res1;
	vector<int> res2;
	vector<int> res3;

};

TEST_F(NextPermutationTest, nextPermutation1Test) {

	NextPermutation solution = NextPermutation();
	solution.nextPermutation1(source1);
	solution.nextPermutation1(source2);
	solution.nextPermutation1(source3);

	EXPECT_EQ(res1, source1);
	EXPECT_EQ(res2, source2);
	EXPECT_EQ(res3, source3);
}

TEST_F(NextPermutationTest, nextPermutation2Test) {

	NextPermutation solution = NextPermutation();
	solution.nextPermutation2(source1);
	solution.nextPermutation2(source2);
	solution.nextPermutation2(source3);

	EXPECT_EQ(res1, source1);
	EXPECT_EQ(res2, source2);
	EXPECT_EQ(res3, source3);
}