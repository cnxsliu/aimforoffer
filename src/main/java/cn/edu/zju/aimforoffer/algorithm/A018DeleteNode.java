package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/17 22:47
 * @strategy 1、要删除结点i，先把结点i的下一个节点j的内容复制到i，然后把i的指针指向节点j的下一个节点。
 * 2、此时在删除结点j，其效果刚好是把结点i删除了。
 */
public class A018DeleteNode {
    public void DeleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null) {
            return;
        }
        if (head == deListNode) {
            head = null;
        } else {
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }
}
