package G20200343030379;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *  433. 最小基因变化
 *  一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，基因序列由"AACCGGTT"?变化至?"AACCGGTA"?即发生了一次基因变化。
 *
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * 返回值: 1
 * 示例 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * 返回值: 2
 * 示例 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * 返回值: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考题解：https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/java-dfs-hui-su-by-1yx/
 */
public class LeetCode_433_379 {
    public static void main(String[] args) {
        int i = new LeetCode_433_379().minMutation_2("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(i);


    }

    /**
     * 队列遍历法-->广度优先搜索 BFS
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 75.78% 的用户
     * 内存消耗 : 36.9 MB , 在所有 Java 提交中击败了 5.13% 的用户
     */
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 1;

        //初始化集合、变量
        Set bankSet=new HashSet();
        char[] charSet=new char[]{'A','C','G','T'};
        Queue<String> queue=new LinkedList<>();
        Set visited=new HashSet();


        //初始化数据
        int lever=0;
        queue.add(start);
        visited.add(start);

        for (String b : bank) {
            bankSet.add(b);
        }

        //迭代处理
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- >0){
                String poll = queue.poll();
                if(poll.equals(end)){
                    return lever;
                }

                //处理每个字符
                char[] chars = poll.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old=chars[i];

                    for (char c : charSet) {
                        //组成新的字符串
                        chars[i]=c;

                        String next=new String(chars);

                        //判断是否满足bank,不能是访问过的
                        if(!visited.contains(next) && bankSet.contains(next)){
                            //添加到队列
                            queue.add(next);
                            visited.add(next);
                        }

                    }

                    chars[i]=old;
                }


            }
            lever++;
        }
        return -1;

    }

    /**
     * 队列遍历法-->广度优先搜索 BFS，对比minMutation()上面的写法进行优化
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 5.13% 的用户
     */
    public int minMutation_2(String start, String end, String[] bank) {
        if(start.equals(end)) return 1;

        //初始化集合、变量
        Queue<String> queue=new LinkedList<>();
        Set visited=new HashSet();


        //初始化数据
        int lever=0;
        queue.add(start);
        visited.add(start);

        //迭代处理
        while (!queue.isEmpty()){
            int size = queue.size();
            //迭代每一层，每层 level+1
            while (size-- >0){
                String poll = queue.poll();
                if(poll.equals(end)){
                    return lever;
                }

                //处理每个字符
                char[] chars = poll.toCharArray();
                for (String b : bank) {
                    if(visited.contains(b)){
                        continue;
                    }
                    int diff=0;
                    for (int i = 0; i < chars.length; i++) {
                        if(chars[i]!=b.charAt(i)){
                            if(++diff>1){
                                break;
                            }
                        }
                    }

                    //检查是否属于基因库
                    if(diff==1){
                        queue.add(b);
                        visited.add(b);
                    }

                }
            }
            lever++;
        }
        return -1;

    }

    /**
     * 递归法-->深度优先搜索 DFS，（不建议使用深度优先，如果bank很多，那超时是必然的）
     * 参考题解：https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/java-dfs-hui-su-by-1yx/
     */
    int minStepCount=Integer.MAX_VALUE;
    public int minMutation2(String start, String end, String[] bank) {
        //非法性判断
        if(start.equals(end)) return 1;
        if(bank==null || bank.length==0) return -1;
        dfs(new HashSet<String>(),0,start,end,bank);
        return (minStepCount==Integer.MAX_VALUE)?-1:minStepCount;
    }

    /**
     *
     * @param visited 遍历过的字符
     * @param stepCount 走过的次数
     * @param currentStr 当前处理的字符
     * @param end  目标字符
     * @param bank 基因库
     */
    public void dfs(Set<String> visited,int stepCount,String currentStr,String end,
                    String[] bank){
        if(currentStr.equals(end)){
            minStepCount=Math.min(minStepCount,stepCount);
            return;
        }

        //扫描基因库，检查差值为1的基因
        for (String str : bank) {
            int diff=0;//两个字符串对比下来有几个不同
            for (int i = 0; i < currentStr.length(); i++) {
                if(currentStr.charAt(i)!=str.charAt(i)){
                    //超过1次以上即退出,没必要继续判断
                    if(++diff >1) {
                        break;
                    }
                }
            }

            //检查是否遍历过,差值必须为1
            if(diff==1 && !visited.contains(str) ){
                visited.add(str);
                //递归
                dfs(visited,stepCount+1,str,end,bank);
                //visited.remove(str);
            }

        }
    }


}
