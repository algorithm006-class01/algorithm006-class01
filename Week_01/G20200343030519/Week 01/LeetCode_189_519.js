// https://leetcode-cn.com/problems/rotate-array/

var rotate = function(nums, k) {
    var n = nums.length;
    k %= n;
    if (n == 1) {
        return;
    }
    var tmp = 0;
    myReverse(0, n - 1);
    myReverse(0, k - 1);
    myReverse(k, n - 1);
    function myReverse(start, end) {
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    } 
};