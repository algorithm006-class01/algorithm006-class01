package trapping_rain_water;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int n=0;n<height.length;n++){
            if (stack.empty()){
                stack.push(n);
                continue;
            }
            if (height[n]<=height[stack.peek()]){
                stack.push(n);
                continue;
            }else{
                while(!stack.isEmpty() && (height[n] > height[stack.peek()])){
                    int wl = height[stack.pop()];
                    if (stack.empty()){
                        break;
                    }
                    water = water + (n-stack.peek()-1) * (Math.min(height[stack.peek()],height[n])-wl);
                }
                stack.push(n);
            }
        }
        return water;
    }

    public static void main(String[] args) {
        //int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] nums = {4,2,3};
        Solution s = new Solution();
        System.out.println(s.trap(nums));
    }
}
