class Solution {
    public int removeDuplicates(int[] nums) {
        /*声明一个下标变量，从0开始*/
        int k=0;
        /*遍历数组，从第二个元素开始*/
        for(int i=1;i<nums.length;i++){
            /*对比最前一个不同的元素是否与当前元素不相同，不相同则赋值最前不同的元素为当前元素*/
            if(nums[k]!=nums[i]){
                /*不能把之前的覆盖了，得往后移动一位再赋值*/
                nums[++k]=nums[i];
            }
        }
        /*个数就是下标+1*/
        return k+1;
    }
}