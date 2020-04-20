/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 *
 * https://leetcode-cn.com/problems/design-twitter/description/
 *
 * algorithms
 * Medium (37.05%)
 * Likes:    105
 * Dislikes: 0
 * Total Accepted:    11.7K
 * Total Submissions: 28.2K
 * Testcase Example:  '["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]\n' +
  '[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]'
 *
 * 
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * 
 * 
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId):
 * 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 
 * 
 * 示例:
 * 
 * 
 * Twitter twitter = new Twitter();
 * 
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * 
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * 
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * 
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * 
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * 
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * 
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * 
 * 
 */

import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
// @lc code=start

/*
 * 解决方案：
 *      1. 为了高效查询本人的发推历史，使用HashMap存储本人user -> 历史推文的映射
 *        1.1 历史推文使用LinkedList来存储，便于头部插入
 *      2. 为了便于记录本人follow的对象，使用HashMap存储本人user -> 本人关注对象集合
 *        2.1 本人关注对象集合使用HashSet来存储，便于高效查询
 *      3. 设置全局的Twitter时钟，并记录每条推文与发文时间映射表twitterid -> tick
 * 
 * 本题的两个核心点：
 *      1. 使用什么样的数据结构来存储信息，才能保证各操作的高效性；
 *      2. 如何取出 10 most recent tweet；
 */
class Twitter {
    private int tick; // twitter时钟
    private Map<Integer, List<Integer>> posts; // userID -> 本人推文
    private Map<Integer, Set<Integer>> followees; // userID -> 本人关注的人
    private Map<Integer, Integer> postTick; // 发推时间
    private static final int LIMIT = 10;

    /** Initialize your data structure here. */
    public Twitter() {
        posts = new HashMap<>();
        followees = new HashMap<>();
        postTick = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Integer> userPosts = this.posts.computeIfAbsent(userId, k -> new LinkedList<>());
        if (userPosts.size() == LIMIT)
            userPosts.remove(userPosts.size() - 1);
        
        userPosts.add(0, tweetId);
        this.postTick.put(tweetId, tick++);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Iterator<Integer> it = this.posts.computeIfAbsent(userId, k -> new LinkedList<>()).iterator();
        for (int i = 0; i < Twitter.LIMIT && it.hasNext(); i++)
            ans.add(it.next());

        for (int uid : this.followees.computeIfAbsent(userId, x -> new LinkedHashSet<>())) {
            if (userId == uid) continue;
            List<Integer> tmp = new ArrayList<>();
            it = posts.computeIfAbsent(uid, x -> new LinkedList<>()).iterator();

            Integer pid1 = ans.size() > 0 ? ans.get(0) : null;
            Integer pid2 = it.hasNext() ? it.next() : null;

            // merge K linked list with 10 items limit
            for (int i = 1; (pid1 != null || pid2 != null) & tmp.size() < LIMIT; ) {
                if (pid1 != null && pid2 != null) {
                    if (this.postTick.get(pid1) > this.postTick.get(pid2)) {
                        tmp.add(pid1);
                        pid1 = i < ans.size() ? ans.get(i++) : null;
                    } else {
                        tmp.add(pid2);
                        pid2 = it.hasNext() ? it.next() : null;
                    }
                } else if (pid1 != null) {
                    tmp.add(pid1);
                    pid1 = i < ans.size() ? ans.get(i++) : null;
                } else {
                    tmp.add(pid2);
                    pid2 = it.hasNext() ? it.next() : null;
                }
            }

            ans = tmp;
        }
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        this.followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        this.followees.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

