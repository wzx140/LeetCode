#include "pch.h"
#include "../../main/c++/Header.h"

#include <unordered_set>

using std::unordered_set;

class Sum3Test : public ::testing::Test {
protected:
	void SetUp() override {
		source.emplace_back(-1);
		source.emplace_back(0);
		source.emplace_back(1);
		source.emplace_back(2);
		source.emplace_back(-1);
		source.emplace_back(-4);

		res1.insert(-1);
		res1.insert(-1);
		res1.insert(2);

		res2.insert(-1);
		res2.insert(0);
		res2.insert(1);
	}

	void TearDown() override {}

	vector<int> source;
	unordered_set<int> res1;
	unordered_set<int> res2;
};



TEST_F(Sum3Test, threeSum1Test) {
	Sum3 solution;
	auto solutions = solution.threeSum1(source);
	unordered_set<int> solution1;
	unordered_set<int> solution2;
	solution1.insert(solutions.at(0).at(0));
	solution1.insert(solutions.at(0).at(1));
	solution1.insert(solutions.at(0).at(2));
	solution2.insert(solutions.at(1).at(0));
	solution2.insert(solutions.at(1).at(1));
	solution2.insert(solutions.at(1).at(2));

	if (res1 == solution1) {
		EXPECT_TRUE(res1 == solution1);
		EXPECT_TRUE(res2 == solution2);
	} else {
		EXPECT_TRUE(res2 == solution1);
		EXPECT_TRUE(res1 == solution2);
	}
}

TEST_F(Sum3Test, threeSum2Test) {
	Sum3 solution;
	auto solutions = solution.threeSum2(source);
	unordered_set<int> solution1;
	unordered_set<int> solution2;
	solution1.insert(solutions.at(0).at(0));
	solution1.insert(solutions.at(0).at(1));
	solution1.insert(solutions.at(0).at(2));
	solution2.insert(solutions.at(1).at(0));
	solution2.insert(solutions.at(1).at(1));
	solution2.insert(solutions.at(1).at(2));

	if (res1 == solution1) {
		EXPECT_TRUE(res1 == solution1);
		EXPECT_TRUE(res2 == solution2);
	} else {
		EXPECT_TRUE(res2 == solution1);
		EXPECT_TRUE(res1 == solution2);
	}
}