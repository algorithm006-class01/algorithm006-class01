class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int left = 0;
        int leftH = height[left];
        int right = height.length -1;
        int rightH = height[right];
        int area = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                area += leftH - height[left];
                left ++;
                if (height[left] > leftH) {
                    leftH = height[left];
                }
            } else {
                area += rightH - height[right];
                right --;
                if (height[right] > rightH) {
                    rightH = height[right];
                }
            }
        }
        return area;
    }
}