#include "gtest/gtest.h"
#include "../../main/c++/header/StoneGame.h"

class StoneGameTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 5,3,4,5 };
	}

	void TearDown() override {}

	vector<int> source;

};

TEST_F(StoneGameTest, stoneGame1Test) {

	StoneGame solution;
	EXPECT_TRUE(solution.stoneGame1(source));
}
