package G20200343030379;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//46. 全排列
public class LeetCode_46_379 {
    // 记录「路径」
    private List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new Stack<Integer>());
        return res;
    }

    //回溯算法（套路题目）
    //参考解法：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    private void backtrack(int[] nums,Stack stack) {
        //退出
        // 触发结束条件
        if(stack.size()>=nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        //执行逻辑

        //循环递归
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择：栈去重
            //这里有两种方法，针对传入的序列是无重复，可以用栈去重。
            //如果传入可能重复，不能用栈去重，只能用int[] 根据索引去重。
            if(stack.contains(nums[i])){
                continue;
            }
            // 做选择
            stack.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums,stack);
            // 取消选择，撤销标记或选择
            stack.pop();
        }

    }

    public List<List<Integer>> permute2(int[] nums) {
        int[] visited=new int[nums.length];
        backtrack2(nums,visited,new Stack<Integer>());
        return res;
    }

    //回溯算法（套路题目）
    //参考解法：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-by-powcai-2/ong-2/
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    private void backtrack2(int[] nums,int[] visited,Stack stack) {
        //退出
        // 触发结束条件
        if(stack.size()>=nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        //执行逻辑

        //循环递归
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择，数组去重--》映射去重
            //这里有两种方法，针对传入的序列是无重复，可以用栈去重。
            //如果传入可能重复，不能用栈去重，只能用int[] 根据索引去重。
            //1代表走过，0代表可以继续走
            if(visited[i]==1){
                continue;
            }
            visited[i]=1;

            // 做选择
            stack.add(nums[i]);
            // 进入下一层决策树
            backtrack2(nums,visited,stack);
            // 取消选择，撤销标记或选择
            visited[i]=0;
            stack.pop();
        }

    }


    public static void main(String[] args) {

    }
}
