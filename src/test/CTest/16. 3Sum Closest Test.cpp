#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

#include <unordered_set>

using std::unordered_set;

class Sum3ClosestTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { -1,2,1,-4 };
		source2 = { 1,1,1,1 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> source2;
};

TEST_F(Sum3ClosestTest, threeSumClosest1Test) {
	Sum3Closest solution;
	EXPECT_EQ(2, solution.threeSumClosest1(source1, 1));
	EXPECT_EQ(3, solution.threeSumClosest1(source2, 0));
}
