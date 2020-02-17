/*
 * 解题思路，双指针法
 * 慢指针记录不重复元素的位置。 快指针遍历数组，同时和慢指针比较。如果两者不相同，就将该元素赋值到慢指针的下一个元素。
*/

int removeDuplicates(int* nums, int numsSize){
    if (numsSize == 0 ) return 0;
    int i = 0;
    int j = 0;
    for ( int i = 0; i < numsSize ; i++){
        if (nums[i] != nums[j]){
            j++;
            nums[j] = nums[i];
        }
    }
    j++;
    return j;

}

