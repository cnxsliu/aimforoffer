package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/6 22:07
 * @strategy 1、根据节点的类型分别进行讨论。
 * 2、如果一个节点有右子树，那么它的下一个节点就是它的右子树的最左子节点。
 * 3、如果一个节点没有右子树，如果节点是它父节点的左子节点，那么它的下一个节点就是它的父节点。
 * 4、如果一个节点没有右子树，且该节点是它父节点的右子节点，需要沿着指向父节点的指针一直向上遍历，
 * 直到找到一个是它父节点的左子节点的节点，如果这样的节点存在，那么这个节点的父节点就是要找的下一个节点。
 */
public class A008GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
