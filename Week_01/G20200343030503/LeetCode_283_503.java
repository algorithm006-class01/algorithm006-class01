class Solution {
    /** 
     *  
     *  1. 遍历数组,如果元素不为0,先用nums[j]记录该值nums[i]
     *  2. 判断如果j与i不想等,把nums[i]所对应的值改为0 否则继续遍历
     *  3. j++
     *  
     *  做这个题目的时候,老师的这段代码思想可以理解,就是最终卡到了赋值 i!=j num[i] = 0 这块,遇到第1个0开始,下一次遍历j和i 就不相同了此时要先使用nums[j]记录nums[i]当前的值,然后把nums[i]修改为0
     **/
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { 
                nums[j] = nums[i];
                if (i != j ) {
                    nums[i] = 0;
                }
                j++;  
            }
        }
    }
}