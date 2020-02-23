/*
    236. Lowest Common Ancestor of a Binary Tree

    1. 終止條件
    2. 找左子樹
    3. 找右子樹
    4. 如果在左右子樹找到pq, 代表pq一個在左一個在右, root就會是LCS
    5. 如果只有在某一邊找到, 代表pq在同一側, 所以LCS就是某一邊找到的本身結果（題目中有提到LCS可以是p或q本身）

    time complexity: O(n), space complexity: O(n)

 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root; // 1.terminal condition, find p,q or not find pq => null

        TreeNode left = lowestCommonAncestor(root.left, p, q); //2.find left side for p, q
        TreeNode right = lowestCommonAncestor(root.right, p, q); //3.find right side for p, q

        if (left != null && right != null) return root; // 4.if find p,q in left and right side, root is LCS !

        return left != null ? left : right; // 5.if only one side find p or q (it means p,q are all in one side), it's the answer because in question we allow a node to be a descendant of itself
    }
}


/*
同場加映...注意本題是 Binary Search Tree, 不是 binary tree

235. Lowest Common Ancestor of a Binary Search Tree

level: easy

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/


因為 bst 有左小右大的特性 （左子樹所有節點皆小於root, 右子樹所有節點皆大於root

1. 所以pq同時比root 大時, 代表pq在右邊, 所以要往右走
2. 所以pq同時比root 小時, 代表pq在左邊, 所以要往左走
3. 其他狀況, 代表找到了, p q在左右兩側了

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

    LCS:

    判斷方式: 找到 LCS的方式 p, q 不在此 LCS 同一側

       //說明1
       if (pVal > parentVal && qVal > parentVal) {

            // 往右走～～
            return lowestCommonAncestor(root.right, p, q);

        } else if (pVal < parentVal && qVal < parentVal) { //說明2
            // 往左走～～
            return lowestCommonAncestor(root.left, p, q);

        } else {//說明3
            //找到了 We have found the split point, i.e. the LCA node.
            return root;
        }


    time complexity: O(n), space complexity: O(n)

 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);

        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);

        } else {
            return root;
        }
    }
}