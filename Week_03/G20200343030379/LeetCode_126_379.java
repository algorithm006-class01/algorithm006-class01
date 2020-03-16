package G20200343030379;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *  126. 单词接龙 II
 *  给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 * ? ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释:?endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解（最全，各种迭代优化算法）：
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40477/Super-fast-Java-solution-(two-end-BFS)
 *
 *  这两个类似
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
 *  https://leetcode-cn.com/problems/word-ladder-ii/solution/bfs-dfs-by-powcai/
 */



public class LeetCode_126_379 {
    /***
     * 注意，其实把这个题理解为一颗树
     *      1、（while (size-- >0){）每迭代一次队列，代表一层，
     *      2、 每个结点可能包含多个子结点，可能包含多个路径，只取最短路径，所以必须用 wordlist（这里不能用arraylist，只能用hashSet类似的，否则是遍历匹配）.contains进行匹配
     * @param args
     */
    public static void main(String[] args) {
        /**
         * "hit"
         * "cog"
         * ["hot","dot","dog","lot","log","cog"]
         */
        new LeetCode_126_379().findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

    /**
     *
     nodeNeighbors每个单词所能匹配是单词 {lot=[dot, log, hot], hit=[hot], log=[cog, dog, lot], dot=[dog, hot, lot], cog=[], hot=[dot, hit, lot], dog=[cog, log, dot]}
     dict单词组 [lot, hit, log, dot, cog, hot, dog]
     distance最短路径  {lot=2, hit=0, log=3, dot=2, cog=4, hot=1, dog=3}
     预期结果
     [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
     * @param start
     * @param end
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        //最短路径
        Map<String,Integer> distance=new HashMap<>();
        //单词set集合
        Set<String> dict=new HashSet<>(wordList);
        //临界值
        Map<String,List<String>> nodeNeighbors=new HashMap<>();
        //每一层的最终值
        List<String> solution=new ArrayList<>();
        //最终值
        List<List<String>> res=new ArrayList<>();
        //把第一个结点添加进去最短路径,作为基数
        distance.put(start,0);
        dict.add(start);


        bfs(start,end,dict,nodeNeighbors,distance);
        dfs(start,end,nodeNeighbors,distance,res,solution);

        return res;
    }

    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        //初始化每个单词的临界值
        for (String str : dict) {
            nodeNeighbors.put(str,new ArrayList<>());
        }
        Queue<String> queue=new LinkedList();
        queue.offer(start);

        while (!queue.isEmpty()){
            int size = queue.size();
            //是否找到结尾标记
            boolean foundEnd=false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //当前最短路径
                int curDistance = distance.get(cur);

                //获取每个临界值
                List<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    //添加到临界组
                    nodeNeighbors.get(cur).add(neighbor);

                    //检查是否遍历过
                    if(!distance.containsKey(neighbor)){
                        //保存最短路径
                        distance.put(neighbor,curDistance+1);

                        //检查是否END最终值
                        if(neighbor.equals(end)){
                            foundEnd=true;
                        }else{
                            //不是最终值，继续迭代
                            queue.offer(neighbor);
                        }

                    }
                }


            }

            //找到结尾标记则不用再查找
            if(foundEnd){
                break;
            }
        }

    }

    private void dfs(String cur, String end, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance,List<List<String>> res, List<String> solution) {
        //添加每个元素
        solution.add(cur);

        //最终值追加到结尾
        if(cur.equals(end)){
            res.add(new ArrayList<>(solution));
            //注意不要return，导致后面不能撤销选择，导致混乱
        }else{
            //遍历当前临界值
            for (String neighbor : nodeNeighbors.get(cur)) {
                //根据最短路径，判断是否继续递归的需要。根据上层最短路径比较当前最短路径，所以要加1
                if(distance.get(neighbor)==distance.get(cur)+1){
                    dfs(neighbor,end,nodeNeighbors,distance,res,solution);
                }
            }
        }


        //撤回选择
        solution.remove(solution.size()-1);
    }


    /**
     * 处理当前字符关联的字符
     * @param node 开始单词
     * @param dict 单词列表
     * @return
     */
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res=new ArrayList<>();
        char[] chars = node.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old=chars[i];
            for(char c='a';c<='z';c++){
                chars[i]=c;
                String next = new String(chars);
                if(dict.contains(next)){
                    res.add(next);
                }
            }
            chars[i]=old;
        }
        return res;
    }



}
