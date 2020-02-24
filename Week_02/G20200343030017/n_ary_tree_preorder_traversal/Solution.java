package week2.n_ary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        recursion(root,list);
        return list;
    }
    public void recursion(Node root, List<Integer> list){
        list.add(root.val);
        if (root.children == null || root.children.isEmpty()){
            //list.add(root.val);
        }else{
            for (int n=0;n<root.children.size();n++){
                recursion(root.children.get(n),list);
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
        System.out.println(s.preorder(node1));
    }
}
