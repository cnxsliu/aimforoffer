package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/22 20:16
 * @strategy 1、使用递归方法，对每个节点的左右子节点进行遍历
 * 2、将每个节点的左节点和右节点进行交换
 * 3、终止条件为：1.根节点为空；2.根节点的左右节点都为空
 */
public class A027MirrorRecursively {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.left = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
