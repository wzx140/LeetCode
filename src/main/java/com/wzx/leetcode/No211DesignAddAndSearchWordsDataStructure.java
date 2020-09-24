package com.wzx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 * @author wzx
 */
public class No211DesignAddAndSearchWordsDataStructure {

  private static class TieTreeNode {
    private boolean leaf = false;
    private final TieTreeNode[] children = new TieTreeNode[26];

    public boolean hasChild(char ch) {
      return children[ch - 'a'] != null;
    }

    public boolean isLeaf() {
      return leaf;
    }

    public TieTreeNode getChild(char ch) {
      return children[ch - 'a'];
    }

    public Stream<TieTreeNode> getAllNotNullChildren() {
      return Arrays.stream(children).filter(Objects::nonNull);
    }

    public void setLeaf(){
      leaf = true;
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

    private final TieTreeNode root;

    public WordDictionary() {
      root = new TieTreeNode();
    }

    /**
     * 最后一位设置为leaf，一个word的结束
     */
    public void addWord(String word) {
      TieTreeNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        node = node.setChild(ch);
      }
      node.setLeaf();
    }

    public boolean search(String word) {
      // 两个队列，major表示当前要遍历的队列，secondary表示下一层要遍历的队列
      Queue<TieTreeNode> major = new LinkedList<>();
      Queue<TieTreeNode> secondary = new LinkedList<>();
      major.add(root);

      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);

        // 调整队列
        if (major.isEmpty()) {
          Queue<TieTreeNode> tmp = major;
          major = secondary;
          secondary = tmp;
        }

        while (!major.isEmpty()) {
          TieTreeNode node = major.poll();
          if (ch == '.') {
            node.getAllNotNullChildren().forEach(secondary::add);
          } else if (node.hasChild(ch)) {
            secondary.add(node.getChild(ch));
          }
        }

        // 不能完成匹配
        if (secondary.isEmpty()) return false;
      }

      // 匹配的最后一位是否是leaf
      return secondary.stream().anyMatch(TieTreeNode::isLeaf);
    }
  }
}
