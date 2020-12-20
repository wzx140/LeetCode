package com.wzx.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/design-twitter/
 *
 * @author wzx
 */
public class No355DesignTwitter {

  /**
   * getNewsFeed使用到了k路归并排序
   */
  public static class Twitter {

    // 全局的时间戳
    private int time = 0;
    private final Map<Integer, Set<Integer>> followMap;
    // user->[(tweet, time)]
    private final Map<Integer, Tweet> tweetMap;

    private static class Tweet {
      public int id;
      public Tweet next = null;
      public int time;

      public Tweet(int id, int time) {
        this.id = id;
        this.time = time;
      }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
      followMap = new HashMap<>();
      tweetMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
      Tweet newTweet = new Tweet(tweetId, time);
      newTweet.next = tweetMap.get(userId);
      tweetMap.put(userId, newTweet);
      time++;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
      List<Integer> followees = new LinkedList<>();
      followees.add(userId);
      if (followMap.containsKey(userId)) {
        followees.addAll(followMap.get(userId));
      }

      // k路归并排序
      List<Integer> res = new LinkedList<>();
      List<Tweet> kList = followees.stream()
              .map(tweetMap::get)
              .filter(Objects::nonNull)
              .collect(Collectors.toList());
      if (kList.size() != 0) {
        PriorityQueue<Tweet> queue = new PriorityQueue<>(kList.size(), (t1, t2) -> t2.time - t1.time);
        queue.addAll(kList);
        while (!queue.isEmpty() && res.size() < 10) {
          Tweet tweet = queue.poll();
          res.add(tweet.id);
          if (tweet.next != null) queue.add(tweet.next);
        }
      }

      return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
      // 默认自我关注
      if (followerId == followeeId) return;
      if (!followMap.containsKey(followerId)) {
        followMap.put(followerId, new HashSet<>());
      }
      followMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
      if (!followMap.containsKey(followerId)) return;

      followMap.get(followerId).remove(followeeId);
    }
  }
}
