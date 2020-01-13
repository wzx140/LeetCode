package per.wzx.introduce.TwoPointerTechnique;

// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
public class MinimumSizeSubarraySum {

    //    simple traversing all substrings
    public int minSubArrayLen1(int s, int[] nums) {
        int length = nums.length + 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    length = Math.min(length, j - i + 1);
                    break;
                }
            }
        }
        return length == nums.length + 1 ? 0 : length;
    }

    //    use binary search
    public int minSubArrayLen2(int s, int[] nums) {

//        get the sum array
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int length = nums.length + 1;
        for (int i = 1; i < sum.length; i++) {
            /*  we want to find array(j~i) that sum>s
               find_index_j :   sum[j] - sum[i] + nums[i-1] >= s
                                sum[j] >= s + sum[i] - nums[i-1]  */
            int index = binary_search(sum, i, sum.length - 1, s + sum[i] - nums[i - 1]);
            if (index != -1) {
                length = Math.min(length, index - i + 1);
            }
        }
        return length == nums.length + 1 ? 0 : length;
    }

    //    use binary search to find the element which is just bigger than key, return the index
    private int binary_search(int[] array, int start, int end, int key) {
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (array[middle] > key) {
                end = middle - 1;
            } else if (array[middle] < key) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return start > array.length - 1 ? -1 : start;
    }

    //    two pointer
    public int minSubArrayLen3(int s, int[] nums) {
        int left = 0;
        int length = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                length = Math.min(length, i - left + 1);
                sum -= nums[left++];
            }
        }
        return length == nums.length + 1 ? 0 : length;
    }
}
