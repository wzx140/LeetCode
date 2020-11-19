package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No391PerfectRectangleTest {

  private final int[][] rectangles1 = {
          {1, 1, 3, 3},
          {3, 1, 4, 2},
          {3, 2, 4, 4},
          {1, 3, 2, 4},
          {2, 3, 3, 4}
  };

  private final int[][] rectangles2 = {
          {1, 1, 2, 3},
          {1, 3, 2, 4},
          {3, 1, 4, 2},
          {3, 2, 4, 4}
  };

  private final int[][] rectangles3 = {
          {1, 1, 3, 3},
          {3, 1, 4, 2},
          {1, 3, 2, 4},
          {3, 2, 4, 4}
  };

  private final int[][] rectangles4 = {
          {1, 1, 3, 3},
          {3, 1, 4, 2},
          {1, 3, 2, 4},
          {2, 2, 4, 4}
  };

  private final int[][] rectangles5 = {
          {0, 0, 1, 1},
          {0, 1, 1, 2},
          {0, 2, 1, 3},
          {1, 0, 2, 1},
          {1, 0, 2, 1},
          {1, 2, 2, 3},
          {2, 0, 3, 1},
          {2, 1, 3, 2},
          {2, 2, 3, 3}
  };

  @Test
  public void isRectangleCover() {
    No391PerfectRectangle solution = new No391PerfectRectangle();
    assertTrue(solution.isRectangleCover(rectangles1));
    assertFalse(solution.isRectangleCover(rectangles2));
    assertFalse(solution.isRectangleCover(rectangles3));
    assertFalse(solution.isRectangleCover(rectangles4));
    assertFalse(solution.isRectangleCover(rectangles5));
  }
}