package Week_01.G20200343030395;

public class LeetCode_3_395 {
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(1);
//
//        ListNode ret;
//        //l1是空的，直接返回l2
//        if(l1 == null) {
//            return l2;
//        }
//        //同上
//        if(l2 == null) {
//            return l1;
//        }
//
//        //先取个头
//        if(l1.val < l2.val) {
//            ret = l1;
//            l1 = l1.next;
//        } else  {
//            ret = l2;
//            l2 = l2.next;
//        }
//
//        //保存头，返回用
//        ListNode head = ret;
//
//        //循环，到其中一个到尾为止，谁小取谁
//        while(l1 != null && l2 != null) {
//            if(l1.val < l2.val) {
//                ret.next = l1;
//                ret = ret.next;
//                l1 = l1.next;
//            } else  {
//                ret.next = l2;
//                ret = ret.next;
//                l2 = l2.next;
//            }
//        }
//
//        //把剩下的接上去
//        if(l1 != null) {
//            ret.next = l1;
//        }
//        //把剩下的接上去
//        if(l2 != null) {
//            ret.next = l2;
//        }
//
//        //return head;
//    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
