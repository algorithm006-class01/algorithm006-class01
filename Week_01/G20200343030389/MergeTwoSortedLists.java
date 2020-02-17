package follow.phenix.ice.algorithm.weekone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.valueOf(val));
        ListNode nextNode = next;
        while (nextNode != null) {
            result.append(", ").append(nextNode.val);
            nextNode = nextNode.next;
        }
        return result.toString();
    }
}


/**
 * @author iceiceice
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode nodeOne = getListNode(new ListNode(1), Arrays.asList(2, 3));
        ListNode nodeTwo = getListNode(new ListNode(1), Arrays.asList(3, 4));
        System.out.println(nodeOne);
        System.out.println(nodeTwo);
//        ListNode newNodeOne = methodOne(nodeOne, nodeTwo);
        ListNode newNodeTwo = methodTwo(nodeOne, nodeTwo);
        System.out.println(newNodeTwo);

    }

    private static ListNode methodTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = methodTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = methodTwo(l2.next, l1);
            return l2;
        }
    }

    /********************************************************************/

    private static ListNode methodOne(ListNode l1, ListNode l2) {
        List<Integer> l1ValueList = getAllValues(l1);
        List<Integer> l2ValueList = getAllValues(l2);
        List<Integer> allValueList = new ArrayList<>();
        allValueList.addAll(l1ValueList);
        allValueList.addAll(l2ValueList);
        allValueList.sort(Comparator.comparingInt(o -> o));
        if (allValueList.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(allValueList.get(0));
        allValueList.remove(0);
        return getListNode(head, allValueList);
    }

    private static ListNode getListNode(ListNode head, List<Integer> list) {
        if (list == null || list.size() == 0) {
            return head;
        }
        ListNode next = head;
        for (int i : list) {
            next.next = new ListNode(i);
            next = next.next;
        }
        return head;
    }

    private static List<Integer> getAllValues(ListNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        ListNode next = node;
        while (next != null) {
            result.add(next.val);
            next = next.next;
        }
        return result;
    }
}
