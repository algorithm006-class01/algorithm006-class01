package G20200343030379;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 解题方法：
 *  1、动态规划
 *  2、动态规划+二分查找法
 *
 * 参考优秀题解：
 *  动态规划+二分查找：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *  官方题解排行榜（动态规划+二分查找(优化版)）：https://leetcode-cn.com/submissions/detail/62318487/
 */
public class LeetCode_300_379 {


    /**
     * 1、动态规划：
     * 时间复杂度 N^2
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 62.41% 的用户
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 5.26% 的用户
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //代表，0,i 上升序列长度
        int[] dp=new int[nums.length];

        //初始化长度都是1
        Arrays.fill(dp,1);

        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            int curMax=0;
            for (int j = 0; j < i; j++){
                //nums[j]左边 nums[i]右边
                if(nums[j] < nums[i]){//表示升序
                    curMax=Math.max(curMax,dp[j]+1);
                }
            }
            dp[i]=Math.max(curMax,dp[i]);
            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;
    }
    /**
     * 1.2、动态规划：减少变量使用,但是需要多次覆盖，时间复杂度更高了
     * 时间复杂度 N^2
     * 空间复杂度：O(N)
     *
     * 执行用时 : 15 ms , 在所有 Java 提交中击败了 45.71% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 5.26% 的用户
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        //代表，0,i 上升序列长度
        int[] dp=new int[nums.length];

        //初始化长度都是1
        Arrays.fill(dp,1);

        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++){
                //nums[j]左边 nums[i]右边
                if(nums[j] < nums[i]){//表示升序
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;
    }


    /**
     * 2、动态规划+二分查找：
     * 时间复杂度  O(NlogN)
     * 空间复杂度： O(N)
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.5 MB , 在所有 Java 提交中击败了 5.26% 的用户
     * @param nums
     * @return
     */
    public int lengthOfLIS3(int[] nums) {
        //代表最长上升序列数组
        int[] tail=new int[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            //直接怼二分查找法
            int left=0,right=maxLength;
            while(left < right){
                //位运算写法
                int mid = (left + right) >> 1;
                //int mid = (left + right) / 2;
                if(tail[mid] < nums[i]){ //右半边查找
                    left = mid + 1;
                }else{ // 左半边查找
                    right = mid;
                }
            }
            tail[left] = nums[i];
            //是否在新位置写入，而不是利旧的位置
            if(maxLength == right) maxLength+=1;
        }

        return maxLength;
    }

    /**
     * 2.1、动态规划+二分查找（二分查找判断方向不同）：
     * 时间复杂度  O(NlogN)
     * 空间复杂度： O(N)
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.5 MB , 在所有 Java 提交中击败了 5.26% 的用户
     * @param nums
     * @return
     */
    public int lengthOfLIS4(int[] nums) {
        //代表最长上升序列数组
        int[] tail=new int[nums.length];
        int maxLength = 0;
        for (int num : nums) {

            int left=0,right=maxLength;
            while (left<right){
                int mid=(left+right) >> 1;
                if(num<= tail[mid]){
                    right = mid;
                }else{
                    left=mid+1;
                }
            }
            if(right==maxLength) maxLength+=1;
            tail[left]=num;
        }
        return maxLength;
    }

    /**
     * 2.2、动态规划+二分查找（优化剪枝版）：
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 5.26% 的用户
     * @param nums
     * @return
     */
    public int lengthOfLIS5(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int tail[]=new int[nums.length];

        //最长上升序列
        int maxLength=0;
        tail[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            //升序直接保存
            if(nums[i] > tail[maxLength]){
                tail[++maxLength]=nums[i];
                continue;
            }


            //直接怼二分查找
            int left=0,right=maxLength;
            while(left < right){
                //除2
                int mid = (left + right) >> 1;
                if(nums[i] > tail[mid]){ //左半边查找
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            tail[left]=nums[i];
            //if(maxLength == right) maxLength+=1;

        }
        return maxLength+1;
    }

    public static void main(String[] args) {
        new LeetCode_300_379().lengthOfLIS3(new int[]{2,3,7});
    }
}