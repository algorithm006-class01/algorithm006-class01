class Solution {
    public void rotate(int[] nums, int k) {
        //k = nums.length % k 此时k表示k个尾部元素会被移动到数组头部
        k%=nums.length;
        //将所有数反转
        reverse(nums,0,nums.length-1);
        //反转0~k位置
        reverse(nums,0,k-1);
        //反转n~k位置
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums,int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}