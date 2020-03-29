package G20200343030015.week_06;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by majiancheng on 2020/3/22.
 */

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_127_015 {

    //将wordList中的词统一变为 *bc, a*c, ab*
    //采用广度搜索 遍历每个值
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int length = beginWord.length();
        Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String tmpWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> tmpList = wordMap.getOrDefault(tmpWord, new ArrayList<String>());
                tmpList.add(word);
                wordMap.put(tmpWord, tmpList);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair<String, Integer>(beginWord, 1));
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair tmpPair = queue.remove();
            String word = (String) tmpPair.getKey();
            int level = (Integer) tmpPair.getValue();
            for (int i = 0; i < length; i++) {
                List<String> tmpWordList = wordMap
                        .getOrDefault(word.substring(0, i) + "*" + word.substring(i + 1, length),
                                new ArrayList<String>(0));
                for (String tmpWord : tmpWordList) {

                    if (tmpWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(tmpWord)) {
                        visited.add(tmpWord);
                        queue.add(new Pair<String, Integer>(tmpWord, level + 1));
                    }
                }
            }

        }

        return 0;
    }
}
