package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/2/22 23:07
 * @strategy
 * 1、从头遍历整个链表，如果当前节点的值与下一个节点的值相同，可以删除。
 * 2、把当前节点的前一个节点和后面值比当前节点的值大的节点相连。
 */
public class A0182DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode preNode = first;

        while (p != null && p.next != null) {
            if(p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                preNode.next = p;
            }else {
                preNode = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
