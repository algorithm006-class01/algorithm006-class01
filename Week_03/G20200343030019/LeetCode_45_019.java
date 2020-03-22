class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int end = nums.length - 1;
        int step = 0;
        Node list = new Node(nums.length - 1);
        Node node = list;
        for (int index = nums.length - 2; index >= 0; index --) {
            int i = nums[index] + index;
            node = new Node(index);
            while (list != null) {
                if (i >= list.val) {
                    node.next = list;
                    list = list.next;
                } else {
                    break;
                }
            }
            if (node.next != null) {
                list = node;
            }
        }
        while (list != null) {
            step ++;
            list = list.next;
        }
        return step - 1;
    }

    class Node {
        int val;
        Node next;
        public Node(int val) {this.val = val;}
    }
}