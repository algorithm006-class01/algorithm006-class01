package week2.n_ary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        recursion(root,list,0);
        return list;
    }
    public void recursion(Node root, List<List<Integer>> list,int level){
        List<Integer> temp;
        if (level+1>list.size()){
            temp=new ArrayList<>();
            list.add(temp);
        }
        list.get(level).add(root.val);
        for (int n=0;n<root.children.size();n++){
            if (root != null){
                recursion(root.children.get(n),list,level+1);
            }
        }
    }
    public static void main(String[] args) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list3 = new ArrayList<>();
        Node node1 = new Node(1,list1);
        Node node2 = new Node(2);
        Node node3 = new Node(3,list3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node3.children.add(node5);
        node3.children.add(node6);
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        Solution s = new Solution();
        System.out.println(s.levelOrder(node1));
    }
}
