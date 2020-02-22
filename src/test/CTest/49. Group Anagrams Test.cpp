#include "gtest/gtest.h"
#include "../../main/c++/header/GroupAnagrams.h"

#include <algorithm>

using std::sort;

class GroupAnagramsTest : public ::testing::Test {
protected:
	void SetUp() override {
		source = { "eat", "tea", "tan", "ate", "nat", "bat" };
		res = { {"ate","eat","tea"},{"bat"},{"nat","tan"} };
	}

	void TearDown() override {}

	vector<string> source;
	vector<vector<string>> res;
};

TEST_F(GroupAnagramsTest, groupAnagrams1Test) {

	GroupAnagrams solution;
	auto anagrams = solution.groupAnagrams1(source);
	for (int i = 0; i < anagrams.size(); i++) {
		sort(anagrams[i].begin(), anagrams[i].end());
	}
	sort(anagrams.begin(), anagrams.end());
	EXPECT_EQ(res, anagrams);
}

TEST_F(GroupAnagramsTest, groupAnagrams2Test) {

	GroupAnagrams solution;
	auto anagrams = solution.groupAnagrams2(source);
	for (int i = 0; i < anagrams.size(); i++) {
		sort(anagrams[i].begin(), anagrams[i].end());
	}
	sort(anagrams.begin(), anagrams.end());
	EXPECT_EQ(res, anagrams);
}
