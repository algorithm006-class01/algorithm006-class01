
class Solution {

    /**
     * 暴力法
     * 每轮遍历找到 最大左右边界 计算并累加面积
     * 直到都遍历完
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int area = 0;
        for (int i=1; i < n - 1;i++) {
            int maxLeft = 0, maxRight = 0;
            // 找到左边界
            for (int j=i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 找到右边界
            for (int j=i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            area += Math.min(maxLeft, maxRight) - height[i];
        }
        return area;
    }

    /**
     * 双指针法
     * 1、定义两个指针 一个指向最左边，一个指向最右边
     * 2、如果左边的值比右边的值小，则更新左边的数据
     * 3、反之，则更新右边数据
     * 4、左边和右边相遇则结束
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = height.length - 1;
        int max_left = 0, max_right = 0;
        int trapArea = 0;
        while(left < right) {
            // 左边小 则更新左边
            if (height[left] < height[right]) {
                if (height[left] > max_left) {
                    max_left = height[left];
                } else {
                    trapArea += max_left - height[left];
                }
                left++;
                // 右边小，则更新右边
            } else {
                if (height[right] > max_right) {
                    max_right = height[right];
                } else {
                    trapArea += max_right - height[right];
                }
                right--;
            }
        }
        return trapArea;
    }
}