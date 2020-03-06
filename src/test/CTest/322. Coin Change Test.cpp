#include "gtest/gtest.h"
#include "../../main/c++/header/CoinChange.h"

class CoinChangeTest : public ::testing::Test {
protected:
	void SetUp() override {
		coins1 = { 1, 2, 5 };
		coins2 = { 2 };
		coins3 = { 474,83,404,3 };
	}

	void TearDown() override {}

	vector<int> coins1;
	vector<int> coins2;
	vector<int> coins3;
};

TEST_F(CoinChangeTest, coinChange1Test) {

	CoinChange solution;
	EXPECT_EQ(3, solution.coinChange1(coins1, 11));
	EXPECT_EQ(-1, solution.coinChange1(coins2, 3));
	EXPECT_EQ(8, solution.coinChange1(coins3, 264));
}

TEST_F(CoinChangeTest, coinChange2Test) {

	CoinChange solution;
	EXPECT_EQ(3, solution.coinChange2(coins1, 11));
	EXPECT_EQ(-1, solution.coinChange2(coins2, 3));
	EXPECT_EQ(8, solution.coinChange2(coins3, 264));
}

TEST_F(CoinChangeTest, coinChange3Test) {

	CoinChange solution;
	EXPECT_EQ(3, solution.coinChange3(coins1, 11));
	EXPECT_EQ(-1, solution.coinChange3(coins2, 3));
	EXPECT_EQ(8, solution.coinChange3(coins3, 264));
}