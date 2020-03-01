package G20200343030015.week_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_105_015 {

    int preIndex = 0;

    int[] preorder;

    int[] inorder;

    Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();

    public TreeNode helper(int leftIdx, int rightIdx) {
        if (leftIdx == rightIdx) {
            return null;
        }

        //处理当前节点逻辑
        int rootVal = preorder[preIndex];
        TreeNode rootNode = new TreeNode(rootVal);
        preIndex++;

        int inIndex = inOrderMap.get(rootVal);
        rootNode.left = helper(leftIdx, inIndex);
        rootNode.right = helper(inIndex + 1, rightIdx);

        return rootNode;
    }

    //先根据前序遍历数组 找到根节点，然后切割中序数组，依次迭代计算
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return helper(0, preorder.length);
    }

}
