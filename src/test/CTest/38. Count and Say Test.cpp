#include "gtest/gtest.h"
#include "../../main/c++/header/CountSay.h"

class CountSayTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(CountSayTest, countAndSay1Test) {

	CountSay solution;
	EXPECT_STREQ("1", solution.countAndSay1(1).c_str());
	EXPECT_STREQ("1211", solution.countAndSay1(4).c_str());
}
