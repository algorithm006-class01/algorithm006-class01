class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        //深度优先题目
	//将所有符合条件的元素放在一个初始为0的多叉树中
	this.n = n;
        this.k = k;
        helper(new TreeNode(0), 0);
        return resultList;
    }

    public void helper(TreeNode node, int floor){
        if (floor == k) return;
        floor++;
        for (int i = node.val+1; i <= n; i++) {
            TreeNode next = new TreeNode(i);
            node.childs.add(next);
            next.prev = node;
            helper(next , floor);

            if (floor == k) {
                //Deque<Integer> deque = new ArrayDeque<>();
                LinkedList<Integer> link = new LinkedList<>();
                link.addFirst(next.val);
                for (int j = 1; j < k; j++) {
                    next = next.prev;
                    link.addFirst(next.val);
                }
                resultList.add(link);
            }
        }
    }

    class TreeNode{
        int val;
        List<TreeNode> childs;
        TreeNode prev;
        public TreeNode(int val) {
            childs = new ArrayList<>();
            this.val = val;
        }
    }
}
