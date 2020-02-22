#include "gtest/gtest.h"
#include "../../main/c++/header/GenerateParenthesis.h"

#include <unordered_set>

using std::unordered_set;

class GenerateParenthesisTest : public ::testing::Test {
protected:
	void SetUp() override {
		this->solutionSet.insert("((()))");
		this->solutionSet.insert("(()())");
		this->solutionSet.insert("(())()");
		this->solutionSet.insert("()(())");
		this->solutionSet.insert("()()()");
	}

	void TearDown() override {}

	unordered_set<string> solutionSet;
};

TEST_F(GenerateParenthesisTest, generateParenthesis1Test) {
	GenerateParenthesis solution;
	vector<string> res = solution.generateParenthesis1(3);

	unordered_set<string> resSet(res.begin(),res.end());
	EXPECT_TRUE(solutionSet == resSet);
}

TEST_F(GenerateParenthesisTest, generateParenthesis2Test) {
	GenerateParenthesis solution;
	vector<string> res = solution.generateParenthesis2(3);

	unordered_set<string> resSet(res.begin(), res.end());
	EXPECT_TRUE(solutionSet == resSet);
}

TEST_F(GenerateParenthesisTest, generateParenthesis3Test) {
	GenerateParenthesis solution;
	vector<string> res = solution.generateParenthesis3(3);

	unordered_set<string> resSet(res.begin(), res.end());
	EXPECT_TRUE(solutionSet == resSet);
}
