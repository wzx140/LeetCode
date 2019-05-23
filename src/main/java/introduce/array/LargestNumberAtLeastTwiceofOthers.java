package main.java.introduce.array;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int max_value = 0;
        int max_index = 0;
        // the second max value
        int max_sec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max_value) {
                max_sec = max_value;
                max_value = nums[i];
                max_index = i;
            }else if (nums[i] > max_sec) {
                max_sec = nums[i];
            }
        }
        if (max_value >= 2 * max_sec) {
            return max_index;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers largestNumberAtLeastTwiceofOthers = new LargestNumberAtLeastTwiceofOthers();
        int[] a = { 0, 0, 4, 3 };
        System.out.println(largestNumberAtLeastTwiceofOthers.dominantIndex(a));
    }

}