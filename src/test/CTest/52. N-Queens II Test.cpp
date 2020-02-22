#include "gtest/gtest.h"
#include "../../main/c++/header/NQueens2.h"

#include <algorithm>

using std::sort;

class NQueens2Test : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(NQueens2Test, totalNQueens1Test) {

	NQueens2 solution;
	EXPECT_EQ(2, solution.totalNQueens1(4));
}
