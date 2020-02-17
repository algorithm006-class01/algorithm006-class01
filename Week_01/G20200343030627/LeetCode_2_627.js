// rotate-array

var rotate = function(nums, k) {
    k = k % nums.length;
    var length = nums.length;
    if (length === 1 ||  k === 0) return;
    
    nums.reverse();
    reverseAny(nums, 0 ,k - 1);
    reverseAny(nums, k, nums.length - 1)
};

function reverseAny(arr, startIdx, endIdx) {
    for (var i=0; i < Math.floor((endIdx - startIdx + 1)/2); i++) {
        var temp = arr[startIdx + i];
        arr[startIdx + i] = arr[endIdx - i];
        arr[endIdx - i] = temp;
    }
}