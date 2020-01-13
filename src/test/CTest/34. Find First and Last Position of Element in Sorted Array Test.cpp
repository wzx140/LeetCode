#include "pch.h"
#include "../../main/c++/Header.h"

class FFLPTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 5,7,7,8,8,10 };
		res1 = { 3,4 };
		res2 = { -1,-1 };
	}

	void TearDown() override {}

	vector<int> source;
	vector<int> res1;
	vector<int> res2;
};

TEST_F(FFLPTest, search1Test) {

	FFLP solution = FFLP();
	EXPECT_EQ(res1, solution.searchRange1(source, 8));
	EXPECT_EQ(res2, solution.searchRange1(source, 6));
}