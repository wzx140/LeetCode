#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

#include <unordered_set>

using std::unordered_set;

class LCPNTest : public ::testing::Test {
protected:
	void SetUp() override {
		res.insert("ad");
		res.insert("ae");
		res.insert("af");
		res.insert("bd");
		res.insert("be");
		res.insert("bf");
		res.insert("cd");
		res.insert("ce");
		res.insert("cf");
	}

	void TearDown() override {}

	unordered_set<string> res;
};

TEST_F(LCPNTest, letterCombinations1Test) {
	LCPN solution;
	auto combinations = solution.letterCombinations1("23");
	unordered_set<string> combinationSet(combinations.begin(), combinations.end());
	EXPECT_TRUE(this->res == combinationSet);
}

TEST_F(LCPNTest, letterCombinations2Test) {
	LCPN solution;
	auto combinations = solution.letterCombinations2("23");
	unordered_set<string> combinationSet(combinations.begin(), combinations.end());
	EXPECT_TRUE(this->res == combinationSet);
}