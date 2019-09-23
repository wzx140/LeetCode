#include "pch.h"
#include "../../main/c++/Header.h"

#include <unordered_set>

using std::unordered_set;

class Sum2Test : public ::testing::Test {
protected:
	void SetUp() override {
		this->source.push_back(2);
		this->source.push_back(7);
		this->source.push_back(11);
		this->source.push_back(15);

		so.insert(0);
		so.insert(1);
	}

	void TearDown() override {}

	vector<int> source;
	unordered_set<int> so;
};

TEST_F(Sum2Test, twoSum1Test) {
	Sum2 solution = Sum2();
	vector<int> res = solution.twoSum1(this->source, 9);
	EXPECT_TRUE(this->so == unordered_set<int>(res.begin(), res.end()));
}

TEST_F(Sum2Test, twoSum2Test) {
	Sum2 solution = Sum2();
	vector<int> res = solution.twoSum2(this->source, 9);
	EXPECT_TRUE(this->so == unordered_set<int>(res.begin(), res.end()));
}

TEST_F(Sum2Test, twoSum3Test) {
	Sum2 solution = Sum2();
	vector<int> res = solution.twoSum3(this->source, 9);
	EXPECT_TRUE(this->so == unordered_set<int>(res.begin(), res.end()));
}
