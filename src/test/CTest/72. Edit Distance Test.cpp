#include "gtest/gtest.h"
#include "../../main/c++/header/EditDistance.h"

class EditDistanceTest : public ::testing::Test {
protected:
	void SetUp() override {
		source11 = "horse";
		source12 = "ros";
		source21 = "intention";
		source22 = "execution";
	}

	void TearDown() override {}

	string source11;
	string source12;
	string source21;
	string source22;
};

TEST_F(EditDistanceTest, minDistance1Test) {

	EditDistance solution;
	EXPECT_EQ(3, solution.minDistance1(source11, source12));
	EXPECT_EQ(5, solution.minDistance1(source21, source22));
}

TEST_F(EditDistanceTest, minDistance2Test) {

	EditDistance solution;
	EXPECT_EQ(3, solution.minDistance2(source11, source12));
	EXPECT_EQ(5, solution.minDistance2(source21, source22));
}