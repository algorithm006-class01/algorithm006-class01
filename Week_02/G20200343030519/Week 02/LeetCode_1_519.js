// https://leetcode-cn.com/problems/two-sum/

var twoSum = function(nums, target) {
    var result = new Map();
    var len = nums.length;
    var diff = 0;
    var out = [];
    for(var i=0;i<len;i++){
        diff = target - nums[i];
        var diffVal = result.get(diff);
        if(result.has(diff) && diffVal!=i){
            out.push(i);
            out.push(diffVal);
            return out;
        }else{
            result.set(nums[i],i);
        }
    }
};