package introduce.conclution;

//
public class MoveZeroes {
    /**
     * the same like this
     * @link introduce.conclution.RemoveDuplicatesFromSortedArray
     */
    public void moveZeroes1(int[] nums) {
        int storeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[storeIndex++] = nums[i];
            }
        }

//        fill with zero
        for (int i = storeIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * use two pointer between zeros, the same like this
     * @link introduce.TwoPointerTechnique.MinimumSizeSubarraySum#minSubArrayLen3
     */
    public void moveZeroes2(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[slow];
                nums[slow++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
