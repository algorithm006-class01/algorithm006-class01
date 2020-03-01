package com;

public class leetcode283 {
    public void moveZeroes(int[] nums) {
        //1 读懂题目要求：
        //  将数组中 0 移动到数组的末尾，同时保持非零元素的相对顺序
        //  必须在原数组上操作，不能拷贝额外的数组
        //  尽量减少操作次数
        //2 解题思路：

        // 解法1： loop数组非0的当前loop count+1 一次从0开始替换不为0的元素，然后在loop 从count开始剩余的元素都是0
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[count++] = nums[i];
//            }
//        }
//        for (int i = count; i <nums.length ; i++) {
//            nums[i] = 0;
//        }

        // 解法2： 上述使用了两个循环还可以在进行优化：通过类似的两个指针快慢指针，进行替换操作
        for (int i = 0,count = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                //快慢指针进行元素替换操作
//                int temp = nums[i];
//                nums[i] = nums[count];
//                nums[count] = temp;
//                count++;
                //以上替换操作还可以在优化 可以将temp优化掉
                if (count != i){//防止第一个非0的数字导致错误
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }
}
