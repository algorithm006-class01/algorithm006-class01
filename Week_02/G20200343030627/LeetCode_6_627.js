// lowest-common-ancestor-of-a-binary-tree

var lowestCommonAncestor = function(root, p, q) {
    if (!root) return null;

    var resultNode = null;
    recurseTree(root, p, q);

    function recurseTree(root, p, q) {
        // t
        if (resultNode) return false;
        if (!root) return false;
        // p
        var left = recurseTree(root.left, p, q) ? 1 : 0;
        var right = recurseTree(root.right, p, q) ? 1 : 0;
        var mid = (root == p || root == q) ? 1 : 0;

        if ((left + right + mid) > 1) {
            resultNode = root;
            return true;
        }
        
        return (left + right + mid) > 0;
        // d
    }

    return resultNode;
};