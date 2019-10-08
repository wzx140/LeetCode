#include "pch.h"
#include "../../main/c++/Header.h"

#include <unordered_set>

using std::unordered_set;

class RemoveElementTest : public ::testing::Test {
protected:
	void SetUp() override {
		this->source1 = { 3,2,2,3 };
		this->res1.insert(2);
		this->res1.insert(2);

		this->source2 = { 0,1,2,2,3,0,4,2 };
		this->res2.insert(0);
		this->res2.insert(1);
		this->res2.insert(3);
		this->res2.insert(0);
		this->res2.insert(4);
	}

	void TearDown() override {}

	vector<int> source1;
	unordered_set<int> res1;

	vector<int> source2;
	unordered_set<int> res2;
};

TEST_F(RemoveElementTest, removeElement1Test) {

	RemoveElement solution = RemoveElement();
	EXPECT_EQ(2, solution.removeElement1(this->source1, 3));
	unordered_set<int> solution1(this->source1.begin(), this->source1.end() - 1);
	EXPECT_EQ(this->res1, solution1);

	EXPECT_EQ(5, solution.removeElement1(this->source2, 2));
	unordered_set<int> solution2(this->source2.begin(), this->source2.end() - 3);
	EXPECT_EQ(this->res2, solution2);
}

TEST_F(RemoveElementTest, removeElement2Test) {

	RemoveElement solution = RemoveElement();
	EXPECT_EQ(2, solution.removeElement2(this->source1, 3));
	unordered_set<int> solution1(this->source1.begin(), this->source1.end() - 1);
	EXPECT_EQ(this->res1, solution1);

	EXPECT_EQ(5, solution.removeElement2(this->source2, 2));
	unordered_set<int> solution2(this->source2.begin(), this->source2.end() - 3);
	EXPECT_EQ(this->res2, solution2);
}

TEST_F(RemoveElementTest, removeElement3Test) {

	RemoveElement solution = RemoveElement();
	EXPECT_EQ(2, solution.removeElement3(this->source1, 3));
	unordered_set<int> solution1(this->source1.begin(), this->source1.end() - 1);
	EXPECT_EQ(this->res1, solution1);

	EXPECT_EQ(5, solution.removeElement3(this->source2, 2));
	unordered_set<int> solution2(this->source2.begin(), this->source2.end() - 3);
	EXPECT_EQ(this->res2, solution2);
}