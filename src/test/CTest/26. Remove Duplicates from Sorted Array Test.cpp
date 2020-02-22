#include "gtest/gtest.h"
#include "../../main/c++/header/RDSA.h"

class RDSATest : public ::testing::Test {
protected:
	void SetUp() override {
		this->source1 = { 1,1,2 };
		this->source2 = { 0,0,1,1,1,2,2,3,3,4 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> res1{ 1,2 };

	vector<int> source2;
	vector<int> res2{ 0,1,2,3,4 };
};

TEST_F(RDSATest, removeDuplicates1Test) {

	RDSA solution;
	EXPECT_EQ(2, solution.removeDuplicates1(this->source1));
	EXPECT_EQ(this->res1.at(0), this->source1.at(0));
	EXPECT_EQ(this->res1.at(1), this->source1.at(1));

	EXPECT_EQ(5, solution.removeDuplicates1(this->source2));
	EXPECT_EQ(this->res2.at(0), this->source2.at(0));
	EXPECT_EQ(this->res2.at(1), this->source2.at(1));
	EXPECT_EQ(this->res2.at(2), this->source2.at(2));
	EXPECT_EQ(this->res2.at(3), this->source2.at(3));
	EXPECT_EQ(this->res2.at(4), this->source2.at(4));
}

TEST_F(RDSATest, removeDuplicates2Test) {

	RDSA solution;
	EXPECT_EQ(2, solution.removeDuplicates2(this->source1));
	EXPECT_EQ(this->res1.at(0), this->source1.at(0));
	EXPECT_EQ(this->res1.at(1), this->source1.at(1));

	EXPECT_EQ(5, solution.removeDuplicates2(this->source2));
	EXPECT_EQ(this->res2.at(0), this->source2.at(0));
	EXPECT_EQ(this->res2.at(1), this->source2.at(1));
	EXPECT_EQ(this->res2.at(2), this->source2.at(2));
	EXPECT_EQ(this->res2.at(3), this->source2.at(3));
	EXPECT_EQ(this->res2.at(4), this->source2.at(4));
}
