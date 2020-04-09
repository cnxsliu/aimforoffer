package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/9 22:00
 * @strategy
 * 1、使用中序遍历，左右递归，中间处理
 * 2、中序遍历单独作为一个方法，主方法调用中序遍历方法，同时对输入参数进行校验
 */
public class A054KthNode {
    private static int index = 0;

    public static TreeNode getKthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        TreeNode node = getKthNodeCore(pRoot, k);
        return node;
    }

    public static TreeNode getKthNodeCore(TreeNode pRooot, int k) {
        TreeNode KthNode = null;
        if (pRooot.left != null) {
            KthNode = getKthNode(pRooot.left, k);
        }
        if (KthNode == null) {
            if (index == k) {
                return pRooot;
            }
            index++;
        }
        if (pRooot.right != null && KthNode == null) {
            KthNode = getKthNode(pRooot.right, k);
        }
        return KthNode;
    }
}
