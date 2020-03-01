package Week_02.G20200343030395;

import java.util.HashMap;

public class LeetCode_7_395 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int preIdx = 0;
    int[] preOrder;
    int[] inOrder;

    HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();

    public TreeNode helper(int inLeft, int inRight) {
        if(inLeft == inRight) {
            return null;
        }

        //取出当前节点
        int rootVal = preOrder[preIdx];
        TreeNode root = new TreeNode(rootVal);

        //取出当前节点在中序遍历中的位置
        int index = idxMap.get(rootVal);
        preIdx ++;

        //从当前位置，左前序遍历
        root.left = helper(inLeft, index);
        //从当前位置，右前序遍历
        root.right = helper(index+1, inRight);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){

            this.preOrder = preorder;
            this.inOrder = inorder;

            int idx = 0;
            //按中序遍历建立一个map
            for (Integer val : inorder) {
                idxMap.put(val, idx++);
            }

            return helper(0, inorder.length);
    }

}
