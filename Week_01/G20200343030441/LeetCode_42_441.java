/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

        // 双指针方案
        int a = 0;
        int b = height.length-1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (a <= b){
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if (leftmax < rightmax){
                max += (leftmax - height[a]);
                a++;
            }
            else{
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max;

        // 栈方案
        // if (height == null) return 0;
        // Stack<Integer> s = new Stack<Integer>();
        // int i = 0, maxWater = 0, maxBotWater = 0;
        // while (i < height.length){
        //     if (s.isEmpty() || height[i] <= height[s.peek()]){
        //         s.push(i++);
        //     }
        //     else {
        //         int bot = s.pop();
        //         maxBotWater = s.isEmpty()?
        //         0:(Math.min(height[s.peek()],height[i])-height[bot])*(i-s.peek()-1);
        //         maxWater += maxBotWater;
        //     }
        // }
        // return maxWater;
    }
}
// @lc code=end

