// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

var levelOrder = function(root) {
    var nums = [];
    search(nums, root, 0);
    return nums;
}

function search(nums, node, k) {
    if (node == null) {
        return;
    }
    if (nums[k] == undefined) {
        nums[k] = [];
    }
    nums[k].push(node.val);
    for (var i = 0; i < node.children.length; i++) {
        search(nums, node.children[i], k + 1);
    }
}