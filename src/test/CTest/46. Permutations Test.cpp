#include "gtest/gtest.h"
#include "../../main/c++/header/Permutations.h"

#include <algorithm>

using std::sort;

class PermutationsTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 1,2,3 };
		res = { {1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1} };
	}

	void TearDown() override {}

	vector<int> source;
	vector<vector<int>> res;
};

TEST_F(PermutationsTest, permute1Test) {

	Permutations solution;
	EXPECT_EQ(res, solution.permute1(source));
}

TEST_F(PermutationsTest, permute2Test) {

	Permutations solution;
	auto perms = solution.permute2(source);
	sort(perms.begin(), perms.end());
	EXPECT_EQ(res, perms);
}
