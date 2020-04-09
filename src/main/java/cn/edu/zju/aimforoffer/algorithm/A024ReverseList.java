package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/14 17:27
 * @strategy 1、需要顶一个三个指针（节点），分别用来存储当前节点的下一个节点，当前节点，
 * 当前节点的前一个节点。
 * 2、将当前节点指向前一个节点。
 * 3、将当前节点赋值给前一个节点。
 * 4、将后一个节点赋值给当前节点。
 */
public class A024ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode after = null;
        while (curr != null) {
            after = curr.next;
            curr.next = pre;
            pre = curr;
            curr = after;
        }
        return pre;
    }
}
