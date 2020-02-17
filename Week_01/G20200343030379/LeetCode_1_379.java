package G20200343030379;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName:
 * @Description: TODO
 * @author ban
 * @date
 */
public class LeetCode_1_379 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    //递归法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    //迭代法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //1初始化
        ListNode prehdead=new ListNode(-1);
        ListNode prev=prehdead;

        //2迭代
        while(l1!=null && l2!=null){
            //2.1根据选择路线
            if(l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;

            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;

        }


        //3最后选择收尾
        prev.next=(l1==null?l2:l1);
        //4结束返回
        return prehdead.next;
    }
}
