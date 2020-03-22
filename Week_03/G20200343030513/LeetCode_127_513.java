//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord))
                return 0;
            int n = beginWord.length();
            HashMap<String,ArrayList<String>>all_commons = new HashMap<>();
            wordList.forEach(
                    word->{
                        for(int i=0; i<n; i++){
                            String common = word.substring(0,i)+"*"+word.substring(i+1);
                            if(!all_commons.containsKey(common))
                                all_commons.put(common, new ArrayList<String>());
                            all_commons.get(common).add(word);
                        }
                    }
            );
            HashSet<String> begin = new HashSet<>();
            HashSet<String> end = new HashSet<>();
            begin.add(beginWord);
            end.add(endWord);
            HashSet<String> visited = new HashSet<>();
            int len = 1;
            while(!begin.isEmpty() && !end.isEmpty()){
                if(begin.size()>end.size()){
                    HashSet<String> tmp = begin;
                    begin = end;
                    end = tmp;
                }
                HashSet<String> neighbor = new HashSet<>();
                for(String cur : begin){
                    for(int i=0; i<n; i++){
                        String tmp = cur.substring(0,i)+"*"+cur.substring(i+1);
                        if(!all_commons.containsKey(tmp))
                            continue;
                        for(String str : all_commons.get(tmp)){
                            if(end.contains(str))
                                return len+1;
                            if(!visited.contains(str)){
                                visited.add(str);
                                neighbor.add(str);
                            }
                        }
                    }
                }
                begin = neighbor;
                len++;
            }
            return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
