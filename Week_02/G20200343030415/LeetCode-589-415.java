class Solution {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node root){
        if(root == null){
            return;
        }
        res.add(root.val);
        int s = root.children.size();
        for (int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }
    }


}