class LeetCode_42_527 {
    public int trap(int[]height){
        if (height == null || height.length <=2 ) {
            return 0;
        }
        
        int leftMax = 0;
        int rightMax[] = new int[height.length];
        int result = 0;
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for(int i = 1;i < height.length - 1; i++){
            leftMax = Math.max(leftMax, height[i - 1]);
            int min = Math.min(leftMax, rightMax[i]);
            if (height[i] < min) {
                result += min - height[i];
            }
        }
        return result;
    }
}