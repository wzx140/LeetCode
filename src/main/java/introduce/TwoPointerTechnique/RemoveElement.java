package introduce.TwoPointerTechnique;

// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/
public class RemoveElement {

    //    fast and slow pointer, this function has two many copy(line10)
    public int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    // since the question does not require arrays to be ordered
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return nums.length - j - 1;
    }

}
