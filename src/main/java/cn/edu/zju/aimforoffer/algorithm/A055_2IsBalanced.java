package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/12 15:40
 * @strategy
 * 1、采用后序遍历，从低向上遍历判断，一旦出现不符合条件的情况，则直接返回
 */
public class A055_2IsBalanced {
    public static boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

}
