package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutation-in-string/
 *
 * @author wzx
 */
public class No567PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    String s = s2, p = s1;
    Map<Character, Integer> target = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      target.merge(p.charAt(i), 1, Integer::sum);
    }
    Map<Character, Integer> window = new HashMap<>();
    // [left, right)
    int left = 0, right = 0;

    int valid = 0;
    while (right < s.length()) {
      char rightCh = s.charAt(right);
      right++;
      if (target.containsKey(rightCh)) {
        window.merge(rightCh, 1, Integer::sum);
        if (window.get(rightCh).equals(target.get(rightCh))) valid++;
      }

      while (right - left >= p.length()) {
        if (valid == target.size()) return true;
        char leftCh = s.charAt(left);
        left++;
        if (!target.containsKey(leftCh)) continue;
        if (window.get(leftCh).equals(target.get(leftCh))) valid--;
        window.compute(leftCh, (ch, cnt) -> cnt - 1);
      }
    }

    return false;
  }
}
