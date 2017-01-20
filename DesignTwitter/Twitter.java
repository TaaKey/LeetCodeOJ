package DesignTwitter;

import java.util.*;

/**
 * Created by whong53 on 1/20/17.
 */
public class Twitter {

    private static int timeStamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet nextTweet;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            nextTweet = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> following;
        public Tweet latestTweet;

        public User(int id) {
            this.id = id;
            this.following = new HashSet<>();
            follow(id);
            latestTweet = null;
        }

        public void follow(int id) {
            following.add(id);
        }

        public void unfollow(int id) {
            following.remove(id);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.nextTweet = this.latestTweet;
            this.latestTweet = t;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }
        Set<Integer> following = userMap.get(userId).following;
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>((a, b) -> (b.time - a.time));
        for (int f : following) {
            Tweet tweet = userMap.get(f).latestTweet;
            if (tweet != null) {
                queue.add(tweet);
            }
        }
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            Tweet tweet = queue.poll();
            result.add(tweet.id);
            count++;
            if (tweet.nextTweet != null) {
                queue.add(tweet.nextTweet);
            }
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followeeId == followerId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}
