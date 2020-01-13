package per.wzx.introduce.array;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
 */
public class PlusOne {
    // converting array to number will overflow
    public int[] plusOne1(int[] digits) {
        // convert array to number
        int num = 0;
        for (int i = 0; i < digits.length; i++) {
            num += digits[digits.length - i - 1] * Math.pow(10, i);
        }
        num += 1;
        // convert number to array
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
                // carry
                UnRes[i] = 0;
                carry = true;
            } else {
                // not carry
                UnRes[i] = digit;
                carry = false;
            }
        }
        // highest bit carry
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
}