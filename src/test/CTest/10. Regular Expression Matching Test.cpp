#include "gtest/gtest.h"
#include "../../main/c++/header/RegularExpressionMatching.h"

class RegularExpressionMatchingTest : public ::testing::Test {
protected:
	void SetUp() override {
		source1 = "aa";
		pattern1 = "a";
		source2 = "aa";
		pattern2 = "a*";
		source3 = "ab";
		pattern3 = ".*";
		source4 = "aab";
		pattern4 = "c*a*b";
		source5 = "mississippi";
		pattern5 = "mis*is*p*.";
		
	}

	void TearDown() override {}

	string source1;
	string pattern1;
	string source2;
	string pattern2;
	string source3;
	string pattern3;
	string source4;
	string pattern4;
	string source5;
	string pattern5;
};

TEST_F(RegularExpressionMatchingTest, isMatch1Test) {
	RegularExpressionMatching solution;
	EXPECT_FALSE(solution.isMatch1(source1,pattern1));
	EXPECT_TRUE(solution.isMatch1(source2, pattern2));
	EXPECT_TRUE(solution.isMatch1(source3, pattern3));
	EXPECT_TRUE(solution.isMatch1(source4, pattern4));
	EXPECT_FALSE(solution.isMatch1(source5, pattern5));
}
