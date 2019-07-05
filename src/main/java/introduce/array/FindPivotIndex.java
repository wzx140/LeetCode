package introduce.array;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 */
public class FindPivotIndex {
    // The solution I first came up with
    public int pivotIndex1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        // initialize left sum and right sum
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        if (leftSum == rightSum) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Simplified solution
     */
    public int pivotIndex2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int leftSum = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                    return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}