package LinkedList;

/**
 * Date: 2022/03/16
 * Author: zhangyuyang
 * Description:
 */

public class LinkedList_21 {

    // 方法一
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        // head 是虚拟头节点
        ListNode head = new ListNode(-1), handler = head;
        while(list1!=null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                handler.next = list1;
                list1 = list1.next;
            }else {
                handler.next = list2;
                list2 = list2.next;
            }
            // 指向下一个位置
            handler = handler.next;
        }

        if (list1 != null) {
            handler.next = list1;
        } else if (list2 != null) {
            handler.next = list2;
        }
        return head.next;
    }


    // 方法二
    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        // base case
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val < list2.val)
        {
            list1.next = mergeTwoLists_2(list1.next, list2);
            return list1;
        }else
        {
            list2.next = mergeTwoLists_2(list1,list2.next);
            return list2;
        }

    }
}
