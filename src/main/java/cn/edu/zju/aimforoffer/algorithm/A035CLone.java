package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/4 19:59
 * @strategy 1、根据原始链表的每个节点N创建对应的节点N‘，将N’链接在N的后面
 * 2、根据N指向S，将N‘指向S’
 * 3、把偶数位置的节点链接起来
 */
public class A035CLone {
    public void cloneNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloned = new ComplexListNode();
            cloned.val = node.val;
            cloned.next = node.next;
            cloned.sibling = null;
            node.next = cloned;
            node = cloned.next;
        }
    }

    public void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloned = node.next;
            if (node.sibling != null) {
                cloned.sibling = node.sibling.next;
            }
            node = cloned.next;
        }
    }

    public ComplexListNode reconnectNode(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode clonedHead = null;
        ComplexListNode clonedNode = null;
        if (node != null) {
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        while (node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedHead.next;
            node.next = clonedHead.next;
            node = node.next;
        }
        return clonedHead;
    }

    public ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNode(head);
    }

}
