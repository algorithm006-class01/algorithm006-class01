class Solution {

  List<Integer> result = new ArrayList<Integer>();
  /*递归遍历*/
  public List<Integer> postorder(Node root) {
    traversal(root);
    return result;
  }

  public void traversal(Node node) {
    if (node == null) {
      return;
    }
    List<Node> children = node.children;
    if (children != null) {
      for (Node n : children) {
        traversal(n);
      }
    }
    result.add(node.val);
  }
}

class Solution {

    LinkedList<Integer> result=new LinkedList<Integer>();
    /*迭代*/
    public List<Integer> postorder(Node root) {
        if(root==null){
            return result;
        }
        LinkedList<Node> stack=new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node n=stack.pollLast();
                List<Node> children=n.children;
            if(children!=null){
                for(Node no:children){
                    stack.add(no);
                }
            }
            result.addFirst(n.val);
        }
        return result;
    }
}