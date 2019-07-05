package introduce.TwoPointerTechnique;

// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
public class TwoSumIISorted {

    //    too slow, Not used that the array is sorted
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int[] res = {i + 1, j + 1};
                    return res;
                }
            }
        }
        return null;
    }

    //    also slow
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int add = numbers[i] + numbers[j];
                if (add == target) {
                    int[] res = {i + 1, j + 1};
                    return res;
                } else if (add > target) {
                    break;
                }
            }
        }
        return null;
    }

    //    use two pointer point to head and tail then move to middle
    public int[] twoSum3(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int add = numbers[i] + numbers[j];
            if (add > target) {
                j -= 1;
            } else if (add < target) {
                i += 1;
            } else if (add == target) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}
