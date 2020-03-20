package G20200343030391;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode_127_391 {

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        long start = System.currentTimeMillis();
        int length = new LeetCode_127_391().ladderLengthByBFS(beginWord, endWord, wordList);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 结果：" + length);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);

        // 从两端BFS遍历要用的队列
        Queue<String> startQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> startWayVisited = new HashSet<>();
        Set<String> endWayVisited = new HashSet<>();
        startQueue.offer(beginWord);
        endQueue.offer(endWord);
        startWayVisited.add(beginWord);
        endWayVisited.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);

        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            count++;
            if (startQueue.size() > endQueue.size()) {
                Queue<String> tmp = startQueue;
                startQueue = endQueue;
                endQueue = tmp;
                Set<String> t = startWayVisited;
                startWayVisited = endWayVisited;
                endWayVisited = t;
            }
            int size1 = startQueue.size();
            while (size1-- > 0) {
                String s = startQueue.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    // 保存第j位的原始字符
                    char c0 = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        // 已经访问过了，跳过
                        if (startWayVisited.contains(newString)) {
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回count
                        if (endWayVisited.contains(newString)) {
                            return count + 1;
                        }
                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (allWordSet.contains(newString)) {
                            startQueue.offer(newString);
                            startWayVisited.add(newString);
                        }
                    }
                    // 恢复第j位的原始字符
                    chars[j] = c0;
                }
            }
        }
        return 0;
    }


    public int ladderLengthTowWayBFS_2(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<Integer> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<Integer> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = wordList.get(queue1.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited1.contains(i)) {
                        continue;
                    }
                    if (!canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    if (visited2.contains(i)) {
                        return count + 1;
                    }
                    visited1.add(i);
                    queue1.offer(i);
                }
            }
        }
        return 0;
    }

    /**
     * 双向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthTowWayBFS_1(String beginWord, String endWord, List<String> wordList) {
        // endWord在字典中的下标
        int endWordIndex = wordList.indexOf(endWord);
        if (endWordIndex == -1) {
            return 0;
        }
        //添加startWord到字典，为endWord为起点的广度优先搜索准备数据
        wordList.add(beginWord);
        //startWord 下标
        int startWordIndex = wordList.size() - 1;
        // 用于BFS遍历的队列
        Queue<Integer> startWayQueue = new LinkedList<>();
        Queue<Integer> endWayQueue = new LinkedList<>();
        // 用于保存已访问的单词下标
        Set<Integer> startWayVisited = new HashSet<>();
        Set<Integer> endWayVisited = new HashSet<>();
        //入队
        startWayQueue.offer(startWordIndex);
        endWayQueue.offer(endWordIndex);
        //标记访问
        startWayVisited.add(startWordIndex);
        endWayVisited.add(endWordIndex);
        //
        int count1 = 0;
        int count2 = 0;


        while (!startWayQueue.isEmpty() && !endWayQueue.isEmpty()) {
            count1++;
            int startWayQueueSize = startWayQueue.size();
            while (startWayQueueSize-- > 0) {
                String s = wordList.get(startWayQueue.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    //start方向已经使用过
                    if (startWayVisited.contains(i)) {
                        continue;
                    }
                    if (!canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    //end方向已经使用过
                    if (endWayVisited.contains(i)) {
                        return count1 + count2 + 1;
                    }
                    startWayVisited.add(i);
                    startWayQueue.offer(i);
                }
            }
            count2++;
            int size2 = endWayQueue.size();
            while (size2-- > 0) {
                String s = wordList.get(endWayQueue.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (endWayVisited.contains(i)) {
                        continue;
                    }
                    if (!canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    if (startWayVisited.contains(i)) {
                        return count1 + count2 + 1;
                    }
                    endWayVisited.add(i);
                    endWayQueue.offer(i);
                }
            }
        }
        return 0;
    }

    /**
     * 单向广度优先搜索
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthByBFS(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        boolean[] visited = new boolean[wordList.size()];

        int beginWordIndex = wordList.indexOf(beginWord);
        if (beginWordIndex != -1) {
            visited[beginWordIndex] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            //当前层数量
            int size = queue.size();
            //
            count++;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    //字典中的j元素已经使用过
                    if (visited[j]) {
                        continue;
                    }
                    String s = wordList.get(j);
                    //是否相差一个字母
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    //破案：字典中已经找到endWord
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    //标记已经使用过
                    visited[j] = true;
                    //入队：加入下一层
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    /**
     * 判断是否符合规则，只改变一个字母
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean canConvert(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diffCount;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }


}
