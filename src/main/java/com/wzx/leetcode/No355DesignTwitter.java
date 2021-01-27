package com.wzx.leetcode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/design-twitter/">https://leetcode.com/problems/design-twitter/</a>
 * @author wzx
 */
public class No355DesignTwitter {

  private static class Tweet {
    public int id;
    public int time;
    public Tweet next = null;

    public Tweet(int id, int time) {
      this.id = id;
      this.time = time;
    }
  }

  /**
   * getNewsFeed使用到了k路归并排序
   */
  public static class Twitter {

    // 全局的时间戳
    private int time = 0;
    private final Map<Integer, Set<Integer>> followMap;
    // user->[(id, time)]
    private final Map<Integer, Tweet> tweetMap;

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
      Tweet tweet = new Tweet(tweetId, time);
      tweet.next = tweetMap.get(userId);
      tweetMap.put(userId, tweet);
      time++;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
      // 获取关注列表
      Set<Integer> followSet = followMap.getOrDefault(userId, new HashSet<>());
      // 默认关注自己
      followSet.add(userId);
      // k路归并排序
      PriorityQueue<Tweet> queue = new PriorityQueue<>(followSet.size(), (t1, t2) -> t2.time - t1.time);
      followSet.stream()
              .map(tweetMap::get)
              .filter(Objects::nonNull)
              .forEach(queue::add);
      List<Integer> res = new LinkedList<>();
      while (!queue.isEmpty() && res.size() < 10) {
        Tweet tweet = queue.poll();
        res.add(tweet.id);
        if (tweet.next != null) queue.add(tweet.next);
      }

      return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
      followMap.putIfAbsent(followerId, new HashSet<>());
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
