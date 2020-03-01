package com;

public class leetcode11 {
    public int maxArea(int[] height) {
        //思考：容器的宽度(j-i) * 容器的高度是最小的柱子 = 容器的面积
        //解法1 ： 通过枚举法 循环嵌套比较 时间复杂度较高O(n^2)
        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            //从第一根柱子开始跟所有柱子进行比较
//            for (int j = i; j < height.length; j++) {
//                int area = (j - i) * Math.min(height[i],height[j]);
//                max = Math.max(max,area);
//            }
//        }
        //解法2：通过左右夹逼法，两个指针一个在最左侧，一个在最右侧，往中间移动，时间复杂度为O(n)
        for (int i = 0, j = height.length-1; i < j; ) {
            int h = (height[i] < height[j]) ? height[i++] : height[j--];//获取最小的高度 然后移动其中的一个指针
            int area = (j-i+1) * h;//注意在计算高度时候已经将 i + 1 或 j - 1 了
            max = Math.max(max,area);
        }
        return max;

    }
}
