/*
 * 70. Climbing Stairs
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

 */
public class LeetCode_70_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int result = new LeetCode_70_569().new Solution().climbStairs(n);
		System.out.println(result);
	}

	class Solution {
	    public int climbStairs(int n) {
	        if( n <= 2)
	        	return n;
	        int prepre = 1;
	        int pre = 2;
	        int result = 0;
	        for( int i = 2; i < n; i++ ) {
	        	result = prepre + pre;
	        	prepre = pre;
	        	pre = result;
	        }
	        return result;
	    }
	}
}
