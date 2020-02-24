class Solution {
    public void rotate(int[] nums, int k) {
        // //1、暴力法 时间复杂度O(n) 空间复杂度O(1) 执行用时95ms 内存消耗47.1MB
        // int temp, previous;
        // for (int i = 0; i < k; i++){
        //     previous = nums[nums.length - 1];
        //     for (int j = 0; j < nums.length; j++){
        //         temp = nums[j];
        //         nums[j] = previous;
        //         previous = temp;
        //     }
        // }


        // //2、使用额外数组 时间复杂度O(n) 空间复杂度O(n) 执行用时1ms 内存消耗47.1MB
        // int[] a = new int[nums.length];
        // for (int i = 0; i < nums.length; i++){
        //     a[(i + k) % nums.length] = nums[i];
        // }

        // for (int i = 0; i < nums.length; i++){
        //     nums[i] = a[i];
        // }


        //3、环状替换 时间复杂度O(n) 空间复杂度O(1) 执行用时0ms 内存消耗47.3MB
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++){
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }

        // //4、反转 时间复杂度O(n) 空间复杂度O(1) 执行用时0ms 内存消耗47.3MB
        // k %= nums.length;
        // reverse(nums, 0, nums.length - 1);
        // reverse(nums, 0, k - 1);
        // reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}