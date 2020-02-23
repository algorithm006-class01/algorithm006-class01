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
*/

// 学习莫里斯遍历
var preorderTraversal = function(root) {
    var resultList= [];

    var node = root;
    while (node != null) {
        if (node.left == null) {
            resultList.push(node.val)
            node = node.right;
            continue;
        }

        var predecessor = node.left;

        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }

        if (predecessor.right == null) {
            resultList.push(node.val);
            predecessor.right = node;
            node = node.left;
        } else {
            predecessor.right = null;
            node = node.right;
        }

    }

    return resultList;
}