package cn.edu.zju.aimforoffer.algorithm;

import sun.reflect.generics.tree.Tree;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/9 22:38
 * @strategy
 * 1、使用递归，左右节点分别使用递归，返回时比较左节点深度和右节点深度，取最大值并加1
 * 2、递归终止条件为根节点为null
 */
public class A054TreeDepth {
    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return Math.max(left + 1, right + 1);
    }
}
