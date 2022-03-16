package LinkedList;

import java.util.PriorityQueue;

/**
 * Date: 2022/03/16
 * Author: zhangyuyang
 * Description:
 */
public class LinkedList_23 {

    // method 1
    public ListNode mergeKLists_1(ListNode[] lists) {
        if (lists.length == 0) return null;

        //
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        // ProrityQueue
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val)
        );

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {

            //
            ListNode node = pq.poll();
            p.next = node;

            if (node.next != null) {
                pq.add(node.next);
            }

            p = p.next;
        }

        return dummy.next;
    }
    // end method 1


    // method 2
    ListNode head = new ListNode();
    public ListNode mergeKLists_2(ListNode[] lists) {
        return partition(lists,0,lists.length - 1);
    }
    public ListNode partition(ListNode[] lists,int start,int end)
    {
        if(start == end)
            return lists[start];
        if(start < end)
        {
            int q = (start + end)/2;
            ListNode l1 = partition(lists,start,q);
            ListNode l2 = partition(lists,q+1,end);
            return mergelists(l1,l2);
        }
        else
            return null;
    }

    public ListNode mergelists(ListNode l1,ListNode l2)
    {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        else if(l1.val < l2.val)
        {
            l1.next = mergelists(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next = mergelists(l1,l2.next);
            return l2;
        }
    }
    // end method 2
}
