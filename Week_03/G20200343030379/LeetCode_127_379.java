package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *  127. 单词接龙
 *
 *  给定两个单词（beginWord?和 endWord）和一个字典，找到从?beginWord 到?endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 *  每次转换只能改变一个字母。
 *  转换过程中的中间单词必须是字典中的单词。
 *  说明:
 *
 *  如果不存在这样的转换序列，返回 0。
 *  所有单词具有相同的长度。
 *  所有单词只由小写字母组成。
 *  字典中不存在重复的单词。
 *  你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *  示例?1:
 *
 *  输入:
 *  beginWord = "hit",
 *  endWord = "cog",
 *  wordList = ["hot","dot","dog","lot","log","cog"]
 *
 *  输出: 5
 *
 *  解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *       返回它的长度 5。
 *  示例 2:
 *
 *  输入:
 *  beginWord = "hit"
 *  endWord = "cog"
 *  wordList = ["hot","dot","dog","lot","log"]
 *
 *  输出:?0
 *
 *  解释:?endWord "cog" 不在字典中，所以无法进行转换。
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/word-ladder
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：
 */



public class LeetCode_127_379 {

    public static void main(String[] args) {
        int i = new LeetCode_127_379().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }


    /**
     *  递归法-深度优先搜索
     *  执行用时 :
     *  内存消耗
     *
     *  参考题解：
     *
     */
    int minCount=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.equals(endWord)) return 1;
        Set<String> visited=new HashSet();
        dfs(beginWord,endWord,wordList,visited,0);
        return (minCount==Integer.MAX_VALUE)?0:minCount;

    }

    private void dfs(String begin, String end, List<String> wordList,Set<String> visited,int level) {
        if(begin.equals(end)){
            //if(minCount>level){
                minCount=level;
            //}
            return ;
        }


        for (String word : wordList) {
            if (visited.contains(word)) {
                continue;
            }
            int diff=0;
            for (int i = 0; i < begin.length(); i++) {
                if (begin.charAt(i)!=word.charAt(i)) {
                    if(++diff >1){
                        break;
                    }
                }

            }
            if(diff==1 && !visited.contains(word)){
                visited.add(word);
                dfs(word,end,wordList,visited,level+1);
                visited.remove(word);
            }
        }
    }

    /**
     * 迭代法-广度优先搜索(注意：加了运行日志会变成很慢，注意不要加)
     *
     * 执行用时 :
     * 内存消耗 :
     *
     * 参考题解：https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
     *
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)){
            return 0;
        }

        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level=0;
        while (!queue.isEmpty()){

            int size = queue.size();
            while (size-- >0){
                String poll = queue.poll();
                if(poll.equals(endWord)) return level;

                char[] chars = poll.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old=chars[i];

                    for (char c='a' ;c<='z';c++) {
                        chars[i] = c;

                        String next=new String(chars);

                        if(endWord.equals(next)){
                            return level+1;
                        }

                        if(!visited.contains(next) && wordList.contains(next)){
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    chars[i]=old;
                }
            }
            level++;
        }
        return 0;
    }



}
