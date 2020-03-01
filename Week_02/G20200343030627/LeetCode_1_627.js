// n-ary-tree-postorder-traversal

// 递归，很慢，180ms
/*
var postorder = function(root) {
    if (!root) return [];

    var result = [];
    iter(root, result);

    return result;
};
var iter = function(root, arr) {
    if (!root) return
    root.children.forEach(function(child){
        iter(child, arr);
    });
    arr.push(root.val);
}
*/

// 迭代，80ms
var postorder = function(root) {
    if (!root) return [];

    var stackArr = [root];
    var result = [];

    while (stackArr.length > 0) {
        var curr = stackArr.pop();
        result.push(curr.val);
        curr.children.forEach(child => stackArr.push(child));
    }

    return result.reverse();
}