package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No211DesignAddAndSearchWordsDataStructureTest {

  @Test
  public void wordDictionary() {
    No211DesignAddAndSearchWordsDataStructure.WordDictionary wordDictionary = new No211DesignAddAndSearchWordsDataStructure.WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.addWord("mad");
    assertFalse(wordDictionary.search("pad"));
    assertTrue(wordDictionary.search("bad"));
    assertTrue(wordDictionary.search(".ad"));
    assertTrue(wordDictionary.search("b.."));

    wordDictionary = new No211DesignAddAndSearchWordsDataStructure.WordDictionary();
    wordDictionary.addWord("at");
    wordDictionary.addWord("and");
    wordDictionary.addWord("an");
    wordDictionary.addWord("add");
    assertFalse(wordDictionary.search("a"));
    assertFalse(wordDictionary.search(".at"));
    wordDictionary.addWord("bat");
    assertTrue(wordDictionary.search(".at"));
    assertTrue(wordDictionary.search("an."));
    assertFalse(wordDictionary.search("a.b."));
    assertFalse(wordDictionary.search("b."));
    assertTrue(wordDictionary.search("a.d"));
    assertFalse(wordDictionary.search("."));

    wordDictionary = new No211DesignAddAndSearchWordsDataStructure.WordDictionary();
    wordDictionary.addWord("a");
    wordDictionary.addWord("ab");
    assertTrue(wordDictionary.search("a"));
    assertTrue(wordDictionary.search("a."));
    assertTrue(wordDictionary.search("ab"));
    assertFalse(wordDictionary.search(".a"));
    assertTrue(wordDictionary.search(".b"));
    assertFalse(wordDictionary.search("ab."));
    assertTrue(wordDictionary.search("."));
    assertTrue(wordDictionary.search(".."));
  }
}