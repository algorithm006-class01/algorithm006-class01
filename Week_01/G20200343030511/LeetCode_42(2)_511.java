class Solution {
    public int trap(int[] height) {
     if(height==null&&height.length<=1) return 0;
		int[] max_left = new int[height.length];
		int[] max_right = new int[height.length];		
		for (int i = 1; i < max_left.length-1; i++) {
			max_left[i] = Math.max(max_left[i-1], height[i-1]);
		}		
		for (int i = max_right.length-2; i > 0 ; i--) {
			max_right[i] = Math.max(max_right[i+1], height[i+1]);
		}		
		int maxArea =0;
		for (int i = 1; i < height.length-1; i++) {
			if(height[i]>=max_left[i]||height[i]>=max_right[i]){
				continue;
			}
			maxArea = maxArea+ Math.min(max_left[i], max_right[i])-height[i];						
		}
		return maxArea;
    }
}
