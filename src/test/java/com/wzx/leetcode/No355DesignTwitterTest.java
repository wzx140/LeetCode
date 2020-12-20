package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.wzx.leetcode.No355DesignTwitter.*;
import static org.junit.Assert.*;

public class No355DesignTwitterTest {

  @Test
  public void twitter() {
    Twitter twitter = new Twitter();
    // User 1 posts a new tweet (id = 5).
    twitter.postTweet(1, 5);

    // User 1's news feed should return a list with 1 tweet id -> [5].
    assertEquals(Collections.singletonList(5), twitter.getNewsFeed(1));

    // User 1 follows user 2.
    twitter.follow(1, 2);

    // User 2 posts a new tweet (id = 6).
    twitter.postTweet(2, 6);

    // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    assertEquals(Arrays.asList(6, 5), twitter.getNewsFeed(1));

    // User 1 unfollows user 2.
    twitter.unfollow(1, 2);

    // User 1's news feed should return a list with 1 tweet id -> [5],
    // since user 1 is no longer following user 2.
    assertEquals(Collections.singletonList(5), twitter.getNewsFeed(1));
  }
}