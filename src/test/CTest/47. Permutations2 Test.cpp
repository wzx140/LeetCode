#include "gtest/gtest.h"
#include "../../main/c++/header/Permutations2.h"

#include <algorithm>

using std::sort;

class Permutations2Test : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 1,1,2 };
		res = { {1,1,2},{1,2,1},{2,1,1} };
	}

	void TearDown() override {}

	vector<int> source;
	vector<vector<int>> res;
};

TEST_F(Permutations2Test, permuteUnique1Test) {

	Permutations2 solution;
	auto perm = solution.permuteUnique1(source);
	sort(perm.begin(), perm.end());
	EXPECT_EQ(res, perm);
}
