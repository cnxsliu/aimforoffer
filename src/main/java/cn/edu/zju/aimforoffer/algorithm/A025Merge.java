package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/14 17:45
 * @strategy 1、定义两个指针，分别指向两个链表的头部，每次比较两个指针的值，值小的节点放入到新的链表中，然后后一一位。
 * 2、注意两个链表的非空判断。
 */
public class A025Merge {
    public ListNode mergeTowLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTowLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTowLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTowLists2(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}
