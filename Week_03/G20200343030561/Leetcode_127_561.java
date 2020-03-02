import java.util.*;
/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int step = 0, wordLength = beginWord.length();
        while (!queue.isEmpty()) {
            step ++;
            for (int i = queue.size(); i > 0; i --) {
                String word = queue.poll();
                for (Iterator<String> it = wordSet.iterator(); it.hasNext();) {
                    String element = it.next();
                    int diff = 0;
                    for (int j = 0; j < wordLength; j ++) {
                        if (word.charAt(j) != element.charAt(j))
                            if (++diff > 1) break;
                    }                   
                    if (diff == 1) {
                        if (endWord.equals(element))
                            return step + 1;
                        queue.add(element);
                        it.remove();
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end

