package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No295FindMedianFromDataStreamTest {

  @Test
  public void medianFinder() {
    No295FindMedianFromDataStream.MedianFinder finder = new No295FindMedianFromDataStream.MedianFinder();
    finder.addNum(1);
    finder.addNum(2);
    assertEquals(1.5,finder.findMedian(),0.001);
    finder.addNum(3);
    assertEquals(2.,finder.findMedian(),0.001);
  }
}