#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

#include <algorithm>

using std::sort;

class NQueensTest : public ::testing::Test {
protected:
	void SetUp() override {
		queens = {
			{"..Q.",
			 "Q...",
			 "...Q",
			 ".Q.."},

			 {".Q..",
			 "...Q",
			 "Q...",
			 "..Q."}
		};

	}

	void TearDown() override {}

	vector<vector<string>> queens;
};

TEST_F(NQueensTest, solveNQueens1Test) {

	NQueens solution;
	auto res = solution.solveNQueens1(4);
	sort(res.begin(), res.end());
	EXPECT_EQ(queens, res);
}
