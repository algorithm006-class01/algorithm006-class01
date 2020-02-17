/**
  * 采用双指针向中间移动 
  * 1. 遍历数组 并且定义2个指针  rear和head 如果head < rear 就遍历
  * 2. 求面积 s = x * y 
  *    x = (rear - head)  
  *    y = Math.min(nums[rear],nums[head]);
  * 3. 取出最大的面积
  * 
  * 最容易出现问题的就是: 三目运算中++ -- 的使用
  *
  */
class Solution {
    public int maxArea(int[] nums) {
        int maxArea = 0;
        for (int head = 0,rear = nums.length - 1; head < rear;  ) {
            //int minHeight = nums[head] > nums[rear] ? nums[rear--] : nums[head++] ; 
            int minHeight = 0;
            if (nums[head] > nums[rear]) {
                minHeight = nums[rear];
                rear --;
            }else {
                minHeight = nums[head];
                head ++;
            }
            
            int area = (rear - head + 1) * minHeight;
            maxArea = Math.max(maxArea,area);

        }
        return maxArea;
    }
}