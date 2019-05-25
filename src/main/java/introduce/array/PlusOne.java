package main.java.introduce.array;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
 */
public class PlusOne {
    // 这种方法不可以，因为会溢出
    public int[] plusOne1(int[] digits) {
        // array转化数字
        int num = 0;
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[digits.length - i - 1] * Math.pow(10, i));
            num += digits[digits.length - i - 1] * Math.pow(10, i);
        }
        num += 1;
        // 数字转化array
        int bit = String.valueOf(num).length();
        int[] res = new int[bit];
        for (int i = bit - 1; i >= 0; i--) {
            res[i] = num % 10;
            num /= 10;
        }
        return res;
    }

    public int[] plusOne2(int[] digits) {
        int bit = digits.length;
        int[] UnRes = new int[bit];
        int[] carryRes = new int[bit + 1];
        boolean carry = true;

        for (int i = bit - 1; i >= 0; i--) {
            int digit = digits[i];
            if (carry) {
                digit += 1;
            }
            if (digit >= 10) {
                // 进位
                UnRes[i] = 0;
                carry = true;
            } else {
                // 不进位
                UnRes[i] = digit;
                carry = false;
            }
        }
        // 最高位进位问题
        if (carry) {
            for (int i = 1; i < carryRes.length; i++) {
                carryRes[i] = UnRes[i - 1];
            }
            carryRes[0] = 1;
            return carryRes;
        } else {
            return UnRes;
        }
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] a = { 1, 2, 3, 4 };
        int[] res = plusOne.plusOne2(a);
        for (int num : res) {
            System.out.print(num);
        }
    }
}