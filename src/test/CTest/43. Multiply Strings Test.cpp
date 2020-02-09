#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

class MultiplyStringsTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}

};

TEST_F(MultiplyStringsTest, multiply1Test) {

	MultiplyStrings solution;
	EXPECT_EQ("6", solution.multiply1("2", "3"));
	EXPECT_EQ("56088", solution.multiply1("123", "456"));
}