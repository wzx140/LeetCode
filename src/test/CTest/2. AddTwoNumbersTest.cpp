#include "gtest/gtest.h"
#include "../../main/c++/Header.h"

class AddTwoNumbersTest : public ::testing::Test {
protected:
	void SetUp() override {
		vector<int> source1{ 2,4,3 };
		vector<int> source2{ 5,6,4 };
		num1 = buildNodeList(source1);
		num2 = buildNodeList(source2);
		answer = { 7,0,8 };
	}

	void TearDown() override {}
	ListNode* num1;
	ListNode* num2;
	vector<int> answer;
};

TEST_F(AddTwoNumbersTest, addTwoNumbers1Test) {

	AddTwoNumbers addTwoNumbers = AddTwoNumbers();
	ListNode* res = addTwoNumbers.addTwoNumbers1(num1, num2);
	EXPECT_EQ(answer, decompositeNodeList(res));
}