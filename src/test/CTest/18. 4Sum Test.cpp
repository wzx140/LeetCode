#include "pch.h"
#include "../../main/c++/Header.h"

#include <unordered_set>

using std::unordered_set;

class Sum4Test : public ::testing::Test {
protected:
	void SetUp() override {
		source.emplace_back(-1);
		source.emplace_back(0);
		source.emplace_back(1);
		source.emplace_back(0);
		source.emplace_back(-2);
		source.emplace_back(2);

		res1.insert(-1);
		res1.insert(0);
		res1.insert(0);
		res1.insert(1);

		res2.insert(-2);
		res2.insert(-1);
		res2.insert(1);
		res2.insert(2);

		res3.insert(-2);
		res3.insert(0);
		res3.insert(0);
		res3.insert(2);
	}

	void TearDown() override {}

	vector<int> source;
	unordered_set<int> res1;
	unordered_set<int> res2;
	unordered_set<int> res3;
};



TEST_F(Sum4Test, fourSum1Test) {
	Sum4 solution;
	auto solutions = solution.fourSum1(source,0);
	unordered_set<int> solution1;
	unordered_set<int> solution2;
	unordered_set<int> solution3;
	solution1.insert(solutions.at(0).at(0));
	solution1.insert(solutions.at(0).at(1));
	solution1.insert(solutions.at(0).at(2));
	solution1.insert(solutions.at(0).at(3));
	solution2.insert(solutions.at(1).at(0));
	solution2.insert(solutions.at(1).at(1));
	solution2.insert(solutions.at(1).at(2));
	solution2.insert(solutions.at(1).at(3));
	solution3.insert(solutions.at(2).at(0));
	solution3.insert(solutions.at(2).at(1));
	solution3.insert(solutions.at(2).at(2));
	solution3.insert(solutions.at(2).at(3));

	if (res1 == solution1&&res2==solution2) {
		EXPECT_TRUE(res3 == solution3);
	} else if(res1==solution1 && res2 == solution3){
		EXPECT_TRUE(res3 == solution2);
	} else if (res1 == solution2 && res2 == solution1) {
		EXPECT_TRUE(res3 == solution3);
	} else if (res1 == solution2 && res2 == solution3) {
		EXPECT_TRUE(res3 == solution1);
	} else if (res1 == solution3 && res2 == solution1) {
		EXPECT_TRUE(res3 == solution2);
	} else if (res1 == solution3 && res2 == solution2) {
		EXPECT_TRUE(res3 == solution1);
	}
}