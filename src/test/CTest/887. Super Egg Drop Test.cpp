#include "gtest/gtest.h"
#include "../../main/c++/header/SuperEggDrop.h"

class SuperEggDropTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(SuperEggDropTest, superEggDrop1Test) {

	SuperEggDrop solution;
	EXPECT_EQ(2, solution.superEggDrop1(1, 2));
	EXPECT_EQ(3, solution.superEggDrop1(2, 6));
	EXPECT_EQ(4, solution.superEggDrop1(3, 14));
}

TEST_F(SuperEggDropTest, superEggDrop2Test) {

	SuperEggDrop solution;
	EXPECT_EQ(2, solution.superEggDrop2(1, 2));
	EXPECT_EQ(3, solution.superEggDrop2(2, 6));
	EXPECT_EQ(4, solution.superEggDrop2(3, 14));
}