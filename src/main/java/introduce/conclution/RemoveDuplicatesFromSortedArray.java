package introduce.conclution;

// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1173/
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int storeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[storeIndex] != nums[i]) {
                nums[++storeIndex] = nums[i];
            }
        }
        return storeIndex + 1;
    }

}
