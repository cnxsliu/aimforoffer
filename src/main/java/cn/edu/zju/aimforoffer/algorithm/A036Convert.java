package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/5 16:26
 * @strategy 1、使用递归，定义一个链表的尾节点，使用中序遍历递归处理左右子树
 * 2、最后返回头节点
 */
public class A036Convert {
    public TreeNode Convert(TreeNode root) {
        TreeNode lastList = convertNode(root, null);
        TreeNode head = lastList;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    public TreeNode convertNode(TreeNode root, TreeNode lastList) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        if (cur.left != null) {
            lastList = convertNode(cur.left, lastList);
        }
        root.left = lastList;
        if (lastList != null) {
            lastList.right = root;
        }
        lastList = cur;
        if (cur.right != null) {
            lastList = convertNode(cur.right, lastList);
        }
        return lastList;
    }
}
