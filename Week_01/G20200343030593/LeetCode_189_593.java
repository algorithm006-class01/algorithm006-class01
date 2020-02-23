class Solution {
    /*暴力求解*/
    public void rotate(int[] nums, int k) {
        /*声明一个变量，获取替换当前值的元素*/
        int pre;
        /*声明一个变量，用于交换时的中间值*/
        int temp;
        for(int i=0;i<k;i++){
            /*获取数组的最后一个元素的值*/
            pre=nums[nums.length-1];
            /*遍历*/
            for(int j=0;j<nums.length;j++){
                /*获取替换当前值的元素*/
                temp=nums[j];
                /*当前元素被前一个替换*/
                nums[j]=pre;
                /*重新赋值替换当前元素的元素*/
                pre=temp;
            }
        }
    }

    /*使用另一个数组*/
    public void rotate1(int[] nums, int k) {
        /*声明一个新的数组*/
        int[] a=new int[nums.length];
        /*将右移后的数组存入新的数组中*/
        for(int i=0;i<nums.length;i++){
            a[(i+k)%nums.length]=nums[i];
        }
        /*将新数组中的值赋值到原数组中*/
        for(int i=0;i<nums.length;i++){
            nums[i]=a[i];
        }
    }

    /*反转数组*/
    public void rotate2(int[] nums, int k) {
        /*k对数组长度取余*/
        k %=nums.length;
        /*把整个数组反转*/
        reverse(nums,0,nums.length-1);
        /*把前k和元素反转*/
        reverse(nums,0,k-1);
        /*把后面的数组反转*/
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[end];
            nums[end]=nums[start];
            nums[start]=temp;
            start++;
            end--;
        }
    }
}

