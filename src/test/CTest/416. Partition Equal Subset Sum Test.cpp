#include "gtest/gtest.h"
#include "../../main/c++/header/PartitionEqualSubsetSum.h"


class PartitionEqualSubsetSumTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 1, 5, 11, 5 };
		source2 = { 1, 2, 3, 5 };
	}

	void TearDown() override {}
	vector<int> source1;
	vector<int> source2;
};

TEST_F(PartitionEqualSubsetSumTest, canPartition1Test) {

	PartitionEqualSubsetSum solution;
	EXPECT_TRUE(solution.canPartition1(source1));
	EXPECT_FALSE(solution.canPartition1(source2));
}

TEST_F(PartitionEqualSubsetSumTest, canPartition2Test) {

	PartitionEqualSubsetSum solution;
	EXPECT_TRUE(solution.canPartition2(source1));
	EXPECT_FALSE(solution.canPartition2(source2));
}