package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/22 20:28
 * @strategy 1、利用递归进行判断
 * 2、如果左子树的左节点等于右子树的右节点，左子树的右节点等于左子树的左节点，
 * 并且他们的值都相等，则是对称的。
 */
public class A028IsSymmetrical {
    public static boolean isSymmetrical(TreeNode root) {
        return root == null || isCommon(root.left, root.right);
    }

    public static boolean isCommon(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && isCommon(leftNode.left, rightNode.right) &&
                isCommon(leftNode.right, rightNode.left);
    }
}
