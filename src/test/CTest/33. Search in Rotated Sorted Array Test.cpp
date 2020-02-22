#include "gtest/gtest.h"
#include "../../main/c++/header/SRSA.h"

class SRSATest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { 4,5,6,7,0,1,2 };
	}

	void TearDown() override {}

	vector<int> source;

};

TEST_F(SRSATest, search1Test) {

	SRSA solution;
	EXPECT_EQ(1, solution.search1(source, 5));
	EXPECT_EQ(-1, solution.search1(source, 3));
}

TEST_F(SRSATest, search2Test) {

	SRSA solution;
	EXPECT_EQ(4, solution.search2(source, 0));
	EXPECT_EQ(-1, solution.search2(source, 3));
}
