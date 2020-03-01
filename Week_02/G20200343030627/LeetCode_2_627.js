// n-ary-tree-preorder-traversal

// 递归实现，非常慢232ms
/*
var preorder = function(root) {
    if (!root) return [];

    var result = [];
    iter(root, result);

    return result;
};
var iter = function(root, arr) {
    if (!root) return;

    arr.push(root.val);
    root.children.forEach(function(child){
        iter(child, arr);
    });
}
*/

// 迭代实现 80ms
var preorder = function(root) {
    if (!root) return []

    var stackArr = [root];
    var result = [];

    while (stackArr.length > 0) {
        var curr = stackArr.pop();  // 弹出节点
        result.push(curr.val);          // 记录值
        for (var i=curr.children.length - 1; i >= 0; i--) {
            stackArr.push(curr.children[i]);  // 子节点逆序放回
        }
    }
    return result;
}