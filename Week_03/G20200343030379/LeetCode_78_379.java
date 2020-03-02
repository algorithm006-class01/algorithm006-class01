package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  78. 子集
 *  给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *  解集不能包含重复的子集。
 *
 *  输入: nums = [1,2,3]
 *  输出:
 *  [
 *    [3],
 *    [1],
 *    [2],
 *    [1,2,3],
 *    [1,3],
 *    [2,3],
 *    [1,2],
 *    []
 *  ]
 *
 *
 *  参考思路方法；https://u.geekbang.org/lesson/10?article=199750
 *  注意：有可能都不选的情况。。。。。
 */
public class LeetCode_78_379 {
    public static void main(String[] args) {

    }
    /******第一种风格：递归*************/
    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        return dsf(nums,new ArrayList<>(),stack,0);
    }

    /**
     * 第一种方法第一种风格写法
     * @param nums 元数据
     * @param list 最终返回数据
     * @param stack 保留当前数据
     * @param index  当前索引，第几层
     * @return
     */
    public List<List<Integer>> dsf(int[] nums,List<List<Integer>> list, Stack<Integer> stack, int index){
        //退出条件，最后一层即退出
        if(index==nums.length){
            list.add(new ArrayList<Integer>(stack));
            return list;
        }

        //执行递归
        //不选当前元素，直接跳下一层
        //stack.add(nums[index]);
        dsf(nums,list, stack, index+1);
        //选择当前元素，并跳下一层
        stack.add(nums[index]);
        dsf(nums,list, stack, index+1);

        //清除脏数据
        stack.pop();
        return list;
    }

    /******第一种方法第二种风格：递归*************/
    public List<List<Integer>> subsets2(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        List<List<Integer>> list=new ArrayList<>();
        dsf2(nums,list,stack,0);
        return list;
    }

    /**
     * 第二种风格写法
     * @param nums 元数据
     * @param list 最终返回数据
     * @param stack 保留当前数据
     * @param index  当前索引，第几层
     * @return
     */
    public void dsf2(int[] nums,List<List<Integer>> list, Stack<Integer> stack, int index){
        //退出条件，最后一层即退出
        if(index==nums.length){
            list.add(new ArrayList<Integer>(stack));
            return ;
        }

        //执行递归
        //不选当前元素，直接跳下一层
        //stack.add(nums[index]);
        dsf2(nums,list, stack, index+1);
        //选择当前元素，并跳下一层
        stack.add(nums[index]);
        dsf2(nums,list, stack, index+1);

        //清除脏数据
        stack.pop();
    }

    /******第二种思路：迭代法*************/
    public List<List<Integer>> subsets3(int[] nums) {
        //输入[1,2,3]
        //结构：每个[]都代表一个list集合，就好理解
        //{[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]}
        //存子集，初始化第一个为空
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());

        //迭代nums
        for (int num : nums) {
            //用来存储每一层的集合
            List<List<Integer>> bigList=new ArrayList();
            //迭代子集
            for (List<Integer> re : res) {
                //存储每个元素的集合，比如说[1,2]或者[2,3]
                List list = new ArrayList<>(re);
                list.add(num);
                bigList.add(list);
            }
            //把每一层的集合，追加到最终元素。
            res.addAll(bigList);
        }

        return res;
    }

}
