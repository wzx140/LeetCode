#include "gtest/gtest.h"
#include "../../main/c++/header/TKFE.h"

#include <algorithm>

using std::sort;

class TKFETest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = { 1,1,1,2,2,3 };
		res1 = { 1,2 };
		source2 = { 1 };
		res2 = { 1 };
		source3 = { 1, 1, 1, 2, 2, 33333333 };
		res3 = { 1,2 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> res1;
	vector<int> source2;
	vector<int> res2;
	vector<int> source3;
	vector<int> res3;
};

TEST_F(TKFETest, topKFrequent1Test) {

	TKFE solution;
	EXPECT_EQ(res1, solution.topKFrequent1(source1, 2));
	EXPECT_EQ(res2, solution.topKFrequent1(source2, 1));
	EXPECT_EQ(res3, solution.topKFrequent1(source3, 2));
}
