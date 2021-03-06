// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

var postorder = function(root) {
    if (!root) return [];

    var res = [];
    recusion(root);
    return res;

    function recusion(root){
        if (!root) return;

        for (var i = 0; i < root.children.length; i++){
            recusion(root.children[i]);
        }
        res.push(root.val)
    }
};