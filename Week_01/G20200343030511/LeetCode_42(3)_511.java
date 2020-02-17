class Solution {
   public int trap(int[] height) {		
		int left =1;
		int right =height.length-2;
		int sum =0;
		int max =0;
		int maxRight =0;
		for (int i = 1; i < height.length-1; i++) {
			if(height[left-1]<height[right+1]){				
				max = Math.max(max, height[left-1]);
				if(max>height[left]){
					sum = sum +max-height[left];
				}
				left++;
			}else{				
				maxRight =Math.max(maxRight, height[right+1]);
				if(maxRight>height[right]){
					sum =sum+maxRight-height[right];
				}
				right--;								
			}								
		}
		return sum;		
    }
