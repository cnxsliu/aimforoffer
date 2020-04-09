package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/14 15:30
 * @strategy 1、定义两个指针fast和slow
 * 2、fast先走k - 1步，然后一起走
 * 3、当fast走到最后的时候，slow就是倒数第k个节点
 */
public class A022FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 1) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
