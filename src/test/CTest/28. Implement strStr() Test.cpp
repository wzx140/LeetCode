#include "gtest/gtest.h"
#include "../../main/c++/header/ImplementStrStr.h"

#include <unordered_set>

using std::unordered_set;

class ImplementStrStrTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(ImplementStrStrTest, strStr1Test) {

	ImplementStrStr solution;
	EXPECT_EQ(2, solution.strStr1("hello", "ll"));
	EXPECT_EQ(-1, solution.strStr1("aaaaa", "bba"));
}
