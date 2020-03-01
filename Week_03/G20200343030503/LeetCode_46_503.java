/**
 *
 * 回溯算法: 回到过去,恢复现场
 * 全排列 
 * 注意事项: 1. 借助栈(stack或者LinkedList)、 2.path的重置 3.  res.add(new ArrayList<>(result));
 *
 * 参考: https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 *
 *  
 *
 *
 */
class Solution {



    //执行用时 :2 ms, 在所有 Java 提交中击败了60.71%的用户
    public List<List<Integer>> permute(int[] nums) { //permute : 重新排列
        List<List<Integer>> result = new ArrayList<>();//存放所有结果
        LinkedList<Integer> path = new LinkedList<Integer>(); //存放一次排列[1,2,3]
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,result,path,visited);
        return result; 
    }

    public void backtrack(int[] nums,List<List<Integer>> result,LinkedList<Integer> path,boolean[] visited){
        //1. 选择结束的条件
        if (nums.length == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        } 
        //2. 做选择
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) continue;
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums,result,path,visited);
            //特别注意需要重置result
            visited[i] = false;
            path.removeLast();
        }
    }

    //执行用时 :4 ms, 在所有 Java 提交中击败了16.13%的用户
    // public List<List<Integer>> permute(int[] nums) { //permute : 重新排列
    //     List<List<Integer>> res = new ArrayList<>();//存放所有结果
    //     LinkedList<Integer> result = new LinkedList<Integer>(); //存放一次排列[1,2,3]
    //     backtrack(nums,res,result);
    //     return res; 
    // }

    // public void backtrack(int[] nums,List<List<Integer>> res,LinkedList<Integer> result){
    //     //1. 选择结束的条件
    //     if (nums.length == result.size()) {
    //         res.add(new ArrayList<>(result));
    //         return;
    //     } 
    //     //2. 做选择
    //     for (int i = 0; i < nums.length; i++) {
    //         if (result.contains(nums[i])) {
    //             continue;
    //         }
    //         result.add(nums[i]);
    //         backtrack(nums,res,result);
    //         //特别注意需要重置result
    //         result.removeLast();
    //     }
    // }
}