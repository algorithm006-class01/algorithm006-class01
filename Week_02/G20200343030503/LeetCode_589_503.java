/*
*
*	递归实现N叉树的前序遍历
*
*
*
*
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root,result);
        return result;
    }

    public void helper(Node root,List<Integer> result){
        if (root != null) {
            result.add(root.val);
            if(root.children != null) {
                for (Node node: root.children) {
                    helper(node,result);
                }
            }
           
        }

    }
}