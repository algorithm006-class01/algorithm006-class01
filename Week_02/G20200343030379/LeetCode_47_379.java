package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//47. 全排列 II

/***
 * 回溯算法框架：
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 * 作者：labuladong
 * 链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode_47_379 {
    public static void main(String[] args) {
        new LeetCode_47_379().permuteUnique(new int[]{1,2,1});
    }
    private List<List<Integer>> res=new ArrayList<>();
    private Set<String> set=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited=new int[nums.length];
        //因为算法是根据前面的值判断是否重复，所以必须先排好序
        Arrays.sort(nums);
        backtrack(nums,visited,new Stack<Integer>());
        System.out.println(res);
        return res;
    }

    //回溯算法（套路题目）
    //参考解法：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
    //index 非法的索引
    private void backtrack(int[] nums,int[] visite,Stack stack) {
        /**退出,最后筛选可能耗时多**/
        if(stack.size()>=nums.length){
            if(!set.contains(stack.toString())){
                res.add(new ArrayList<>(stack));
                set.add(stack.toString());
            }
            return;
        }

        //执行逻辑

        //循环递归
        // for 选择 in 选择列表:
        for (int i = 0; i < nums.length; i++) {
            //由于序列是有重复的，不能用该方法排除不合法的选择
            if(visite[i]==1){
                continue;
            }
            visite[i]=1;
            stack.add(nums[i]);

            //进入下一层决策树
            backtrack(nums,visite,stack);

            //撤销选择
            visite[i]=0;
            stack.pop();
        }

    }

    //回溯算法（套路题目）,优化版本
    //参考解法：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-by-powcai-3/
    //index 非法的索引
    private void backtrack2(int[] nums,int[] visite,Stack stack) {
        /**退出,最后筛选可能耗时多**/
        /*if(stack.size()>=nums.length){
            if(!set.contains(stack.toString())){
                res.add(new ArrayList<>(stack));
                set.add(stack.toString());
            }
            return;
        }*/
        if(stack.size()>=nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        //执行逻辑

        //循环递归
        for (int i = 0; i < nums.length; i++) {
            //由于序列是有重复的，不能用该方法排除不合法的选择
            //visite[i]==1 代表当前节点走过。visite[i-1]==0 代表左兄弟已经走完，已经由1赋值为0；并且当前节点跟左兄弟节点一样，则不用重复走
            if(visite[i]==1 || (i>0 && visite[i-1]==0 && nums[i-1]==nums[i])){
                continue;
            }

            visite[i]=1;
            stack.add(nums[i]);

            //进入下一层
            backtrack2(nums,visite,stack);

            //撤销选择
            visite[i]=0;
            stack.pop();
        }


    }

}
