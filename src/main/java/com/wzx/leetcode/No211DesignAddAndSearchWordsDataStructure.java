package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/description/">https://leetcode.com/problems/design-add-and-search-words-data-structure/description/</a>
 */
public class No211DesignAddAndSearchWordsDataStructure {

  private static class TieTreeNode {
    public boolean leaf = false;
    private final TieTreeNode[] children = new TieTreeNode[26];

    public boolean hasChild(char ch) {
      return children[ch - 'a'] != null;
    }

    public TieTreeNode getChild(char ch) {
      return children[ch - 'a'];
    }

    public TieTreeNode setChild(char ch) {
      if (!hasChild(ch)) children[ch - 'a'] = new TieTreeNode();

      return children[ch - 'a'];
    }
  }

  /**
   * 字典树
   */
  public static class WordDictionary {

    private final TieTreeNode root = new TieTreeNode();

    public WordDictionary() {
    }

    /**
     * 最后一位设置为leaf，一个word的结束
     */
    public void addWord(String word) {
      TieTreeNode node = root;
      for (char ch : word.toCharArray()) {
        node = node.setChild(ch);
      }
      node.leaf = true;
    }

    /**
     * bfs
     */
    public boolean search(String word) {
      Deque<TieTreeNode> queue = new LinkedList<>();
      queue.add(root);

      for (char ch : word.toCharArray()) {
        if (queue.isEmpty()) return false;

        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TieTreeNode node = queue.pollFirst();
          // 遇到.则添加所有子节点
          if (ch == '.') {
            for (char j = 'a'; j < 'z'; j++) {
              if (node.hasChild(j)) {
                queue.addLast(node.getChild(j));
              }
            }
          } else if (node.hasChild(ch)) {
            queue.addLast(node.getChild(ch));
          }
        }
      }

      // 匹配的最后一位是否是leaf
      return queue.stream().anyMatch(node -> node.leaf);
    }
  }
}
