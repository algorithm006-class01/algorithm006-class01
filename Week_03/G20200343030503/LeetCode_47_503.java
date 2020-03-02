/**
 *
 * 回溯算法: 回到过去,恢复现场
 * 全排列|| 
 * 
 * 注意事项: 1. nums必须是有序数组 2. 使用java官方推荐的Deque代替Stack 3. 回溯+ 减枝(判断前一个点是否被使用过) 
 *
 *
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //特别需要注意: nums一定要排序否则下变执行nums[i] == nums[i-1]做判断的时候会出错
        Arrays.sort(nums);

        //定义一个存放结果的集合
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //定义一个一趟结果的存放的集合,为方便状态重置,建议使用Deque或者LinkedList , 
        //不推荐使用Stack,java自己的人员都不再使用Stack
        Deque<Integer> stack = new ArrayDeque<>();
        //定义一个数组,确定nums中的数字是否被使用过 0 未使用过,1 使用过
        int[] used = new int[nums.length];
        dfs(nums,result,stack,used);
        return result;
    }

    public void dfs(int[] nums,List<List<Integer>> result,Deque<Integer> stack,int[] used){
        //termination
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        //process
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1)  continue;
            //减枝
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == 1) continue;

            stack.add(nums[i]);
            used[i] = 1;
            //drill down
            dfs(nums,result,stack,used);
            //reverse state
            used[i] = 0;
            stack.removeLast();
        }

    }

}