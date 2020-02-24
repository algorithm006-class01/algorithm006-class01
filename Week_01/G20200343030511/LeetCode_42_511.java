class Solution {
    public int trap(int[] height) {
      if(height==null&&height.length<=1) return 0;
		
		int[] h = height;
		int maxArea =0;
		
		for (int i = 1; i < h.length-1; i++) {
			
			int maxLeft =0;
			int maxRight =0;
			int area;
			
			
			for (int j = 0; j < i; j++) {
				maxLeft = Math.max(h[j], maxLeft);
			}
			for (int j = i+1; j < h.length; j++) {
				maxRight =Math.max(maxRight, h[j]);
			}
			if(h[i]>=maxLeft||h[i]>=maxRight){
                continue;
			}
			area = Math.min(maxRight,maxLeft) - h[i];
			maxArea = maxArea + area;
		}				
		return maxArea;
	}  
    }
