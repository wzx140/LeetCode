#include "gtest/gtest.h"
#include "../../main/c++/header/ValidSudoku.h"

class ValidSudokuTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		source2 = {
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
	}

	void TearDown() override {}

	vector<vector<char>> source1;
	vector<vector<char>> source2;
};

TEST_F(ValidSudokuTest, isValidSudoku1Test) {

	ValidSudoku solution;
	EXPECT_TRUE(solution.isValidSudoku1(source1));
	EXPECT_FALSE(solution.isValidSudoku1(source2));
}

TEST_F(ValidSudokuTest, isValidSudoku2Test) {

	ValidSudoku solution;
	EXPECT_TRUE(solution.isValidSudoku2(source1));
	EXPECT_FALSE(solution.isValidSudoku2(source2));
}
