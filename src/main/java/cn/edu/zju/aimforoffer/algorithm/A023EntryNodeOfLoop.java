package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/14 16:44
 * @strategy 1、定义快慢两个指针，相遇后将快指针直线pHead，然后一起走，每次只往后移动一位
 * 相遇的节点就是所求节点。
 */
public class A023EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                if (fast == slow) {
                    return fast;
                }
            }
        }
        return null;
    }
}
