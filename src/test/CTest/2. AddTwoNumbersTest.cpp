#include "gtest/gtest.h"
#include "../../main/c++/header/AddTwoNumbers.h"
#include "../../main/c++/header/Util.h"

#include <vector>

using std::vector;

class AddTwoNumbersTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<int> source1{ 2,4,3 };
		vector<int> source2{ 5,6,4 };
		num1 = buildNodeList(source1);
		num2 = buildNodeList(source2);
		res = { 7,0,8 };
	}

	void TearDown() override {}
	ListNode* num1;
	ListNode* num2;
	vector<int> res;
};

TEST_F(AddTwoNumbersTest, addTwoNumbers1Test) {

	AddTwoNumbers solution;
	EXPECT_EQ(res, decompositeNodeList(solution.addTwoNumbers1(num1, num2)));
}
