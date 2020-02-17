/**
 * 
 */

class LeetCode_42_G20200343030505 {
	   public int trap(int[] height) {
	         if(height == null || height.length == 0) {
	            return 0;
	        }
	        
	        Stack<Integer> stacks = new Stack<Integer>();
	        int maxArea = 0;
	        for(int i=0;i<height.length;++i) {           
	            
	            int h = 0;
	            while (!stacks.isEmpty() && height[i] > height[stacks.peek()]) {
	                h = height[stacks.pop()];
	                
	                if(!stacks.isEmpty()) {
	                	int area = (Math.min(height[i], height[stacks.peek()]) - h) * (i - stacks.peek() - 1);
	                	maxArea += area;
	                }
	            }  
	           
	            stacks.add(i);           
	        }

	        return maxArea;
	    }
	}