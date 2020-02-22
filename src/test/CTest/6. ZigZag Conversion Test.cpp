#include "gtest/gtest.h"
#include "../../main/c++/header/ZigZagConversion.h"

class ZigZagConversionTest : public ::testing::Test {
protected:
	void SetUp() override {
		test = "PAYPALISHIRING";
	}

	void TearDown() override {}

	string test;
};

TEST_F(ZigZagConversionTest, convert1Test) {
	ZigZagConversion solution;
	EXPECT_STREQ("PAHNAPLSIIGYIR", solution.convert1(this->test, 3).c_str());
	EXPECT_STREQ("PINALSIGYAHRPI", solution.convert1(this->test, 4).c_str());
}

TEST_F(ZigZagConversionTest, convert2Test) {
	ZigZagConversion solution;
	EXPECT_STREQ("PAHNAPLSIIGYIR", solution.convert2(this->test, 3).c_str());
	EXPECT_STREQ("PINALSIGYAHRPI", solution.convert2(this->test, 4).c_str());
}

TEST_F(ZigZagConversionTest, convert3Test) {
	ZigZagConversion solution;
	EXPECT_STREQ("PAHNAPLSIIGYIR", solution.convert3(this->test, 3).c_str());
	EXPECT_STREQ("PINALSIGYAHRPI", solution.convert3(this->test, 4).c_str());
}
