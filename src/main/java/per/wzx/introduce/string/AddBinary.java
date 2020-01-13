package per.wzx.introduce.string;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
 */
public class AddBinary {

    //    use string builder
    public String addBinary1(String a, String b) {
        int length = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < length; i++) {
            int num1 = i < a.length() ? (int) a.charAt(a.length() - i - 1) - 48 : 0;
            int num2 = i < b.length() ? (int) b.charAt(b.length() - i - 1) - 48 : 0;
            int num = num1 + num2;

            // add the low carry
            num += carry;
            carry = 0;

            // Carry to high position
            if (num > 1) {
                num -= 2;
                carry = 1;
            }

            sb.append((char) (num + 48));
        }

        sb.reverse();
        if (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    //    use char array, faster than string builder
    public String addBinary2(String a, String b) {
        int length = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
        char[] res = new char[length];

        int carry = 0;
        for (int i = 0; i < length; i++) {
            int num1 = i < a.length() ? (int) a.charAt(a.length() - i - 1) - 48 : 0;
            int num2 = i < b.length() ? (int) b.charAt(b.length() - i - 1) - 48 : 0;
            int num = num1 + num2;

            // add the low carry
            num += carry;
            carry = 0;

            // Carry to high position
            if (num > 1) {
                num -= 2;
                carry = 1;
            }

            res[length - i - 1] = (char) (num + 48);
        }

        if (res[0] == '0') {
            return String.valueOf(res, 1, res.length - 1);
        }
        return String.valueOf(res);
    }
}