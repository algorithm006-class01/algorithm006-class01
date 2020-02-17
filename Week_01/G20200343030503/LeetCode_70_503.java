/**
 * 爬楼梯
 * 方式一、 使用递归
 * 方式二、 初始化3个值,每次修改前2个值,第三个值等于前两个值只和
 * 
 */
class Solution {
    public int climbStairs(int n) {
            // if (n <= 2) {
            //     return n;
            // }
            // return climbStairs(n - 1) + climbStairs(n - 2);  
            if(n <= 2) {
                return n;
            }  
            int step_one = 1;
            int step_two = 2;
            
            int step_three = 0;
            for (int i = 3 ; i <= n ;i++) {
                step_three = step_two + step_one;
                step_one = step_two;
                step_two = step_three;
            } 
            return step_three;
    }

}