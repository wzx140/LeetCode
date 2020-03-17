#include "gtest/gtest.h"
#include "../../main/c++/header/MNABB.h"

class MNABBTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
	}

	void TearDown() override {}

	vector<vector<int>> source;
};

TEST_F(MNABBTest, findMinArrowShots1Test) {

	MNABB solution;
	EXPECT_EQ(2, solution.findMinArrowShots1(source));
}
