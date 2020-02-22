// binary-tree-preorder-traversal

/*
// 递归
var preorderTraversal = function(root) {
    if (!root) return [];

    var resultArr = [];
    recursion(root);

    return resultArr;

    function recursion(root) {
        if (!root) return;

        resultArr.push(root.val);
        recursion(root.left);
        recursion(root.right);
    }
};
*/
// 迭代, 栈
var preorderTraversal = function(root) {
    if (!root) return [];

    var stackArr = [root];
    var resultArr = [];

    while (stackArr.length > 0) {
        var currNode = stackArr.pop();
        if (!currNode) continue;

        resultArr.push(currNode.val);
        stackArr.push(currNode.right);
        stackArr.push(currNode.left);
    }

    return resultArr;
}