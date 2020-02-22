#include "gtest/gtest.h"
#include "../../main/c++/header/RemoveElement.h"

#include <algorithm>

using std::sort;

class RemoveElementTest : public ::testing::Test {
protected:
	void SetUp() override {
		this->source1 = { 3,2,2,3 };
		this->res1 = { 2,2 };

		this->source2 = { 0,1,2,2,3,0,4,2 };
		this->res2 = { 0,0,1,3,4 };
	}

	void TearDown() override {}

	vector<int> source1;
	vector<int> res1;

	vector<int> source2;
	vector<int> res2;
};

TEST_F(RemoveElementTest, removeElement1Test) {

	RemoveElement solution;
	EXPECT_EQ(2, solution.removeElement1(this->source1, 3));
	vector<int> solution1(this->source1.begin(), this->source1.end() - 2);
	sort(solution1.begin(), solution1.end());
	EXPECT_EQ(this->res1, solution1);

	EXPECT_EQ(5, solution.removeElement1(this->source2, 2));
	vector<int> solution2(this->source2.begin(), this->source2.end() - 3);
	sort(solution2.begin(), solution2.end());
	EXPECT_EQ(this->res2, solution2);
}

TEST_F(RemoveElementTest, removeElement2Test) {

	RemoveElement solution;
	EXPECT_EQ(2, solution.removeElement2(this->source1, 3));
	vector<int> solution1(this->source1.begin(), this->source1.end() - 2);
	sort(solution1.begin(), solution1.end());
	EXPECT_EQ(this->res1, solution1);

	EXPECT_EQ(5, solution.removeElement2(this->source2, 2));
	vector<int> solution2(this->source2.begin(), this->source2.end() - 3);
	sort(solution2.begin(), solution2.end());
	EXPECT_EQ(this->res2, solution2);
}

TEST_F(RemoveElementTest, removeElement3Test) {

	RemoveElement solution;
	EXPECT_EQ(2, solution.removeElement3(this->source1, 3));
	vector<int> solution1(this->source1.begin(), this->source1.end() - 2);
	sort(solution1.begin(), solution1.end());
	EXPECT_EQ(this->res1, solution1);

	EXPECT_EQ(5, solution.removeElement3(this->source2, 2));
	vector<int> solution2(this->source2.begin(), this->source2.end() - 3);
	sort(solution2.begin(), solution2.end());
	EXPECT_EQ(this->res2, solution2);
}
