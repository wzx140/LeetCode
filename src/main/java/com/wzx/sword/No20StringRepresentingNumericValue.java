package com.wzx.sword;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @see <a href="https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/">https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/</a>
 * @author wzx
 */
public class No20StringRepresentingNumericValue {

  enum CharType {
    blank,
    digit,
    sign,
    dot,
    e,
    other
  }

  private CharType char2type(char ch) {
    if (ch == ' ') {
      return CharType.blank;
    } else if (ch >= '0' && ch <= '9') {
      return CharType.digit;
    } else if (ch == '+' || ch == '-') {
      return CharType.sign;
    } else if (ch == '.') {
      return CharType.dot;
    } else if (ch == 'e'||ch=='E') {
      return CharType.e;
    } else {
      return CharType.other;
    }
  }

  /**
   * 0. 开始的空格
   * 1. e前的正负号
   * 2. 小数点前的数字
   * 3. 小数点、小数点后的数字
   * 4. 当小数点前为空格时，小数点、小数点后的数字
   * 5. e
   * 6. e后的正负号
   * 7. e后的数字
   * 8. 结尾的空格
   */
  private final Map[] states = {
          new HashMap<CharType, Integer>() {{
            put(CharType.blank, 0);
            put(CharType.sign, 1);
            put(CharType.digit, 2);
            put(CharType.dot, 4);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.digit, 2);
            put(CharType.dot, 4);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.digit, 2);
            put(CharType.dot, 3);
            put(CharType.e, 5);
            put(CharType.blank, 8);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.digit, 3);
            put(CharType.e, 5);
            put(CharType.blank, 8);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.digit, 3);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.sign, 6);
            put(CharType.digit, 7);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.digit, 7);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.digit, 7);
            put(CharType.blank, 8);
          }},
          new HashMap<CharType, Integer>() {{
            put(CharType.blank, 8);
          }}
  };

  /**
   * 有限状态机
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public boolean isNumber1(String s) {
    int state = 0;
    for (int i = 0; i < s.length(); i++) {
      CharType type = char2type(s.charAt(i));
      if (!states[state].containsKey(type)) return false;
      state = (int) states[state].get(type);
    }

    return state == 2 || state == 3 || state == 8 || state == 7;
  }


  /**
   * 正则表达式
   *
   * time: O(n)
   * space: O(1)
   */
  public boolean isNumber2(String s) {
    String pattern = "^\\s*[+-]?(\\.[\\d]+|[\\d]+(|\\.[\\d]*))([Ee][+-]?[\\d]+|)?[\\s]*$";
    return Pattern.matches(pattern, s);
  }
}
