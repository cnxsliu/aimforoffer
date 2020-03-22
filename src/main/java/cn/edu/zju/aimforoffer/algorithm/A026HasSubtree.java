package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/22 19:40
 * @strategy
 * 1、先找到根结点相同的点
 *
 */
public class A026HasSubtree {
    //递归子函数1
    public boolean hasSubTree (TreeNode source, TreeNode target) {
        //终止条件
        if (target == null) {
            return true;
        }
        if (source == null) {
            return false;
        }
        if (doesTree1HasTree2(source, target)) {
            return true;
        }
        //调用自身
        return hasSubTree(source.left, target) || hasSubTree(source.right, target);
    }

    //递归子函数2
    public static boolean doesTree1HasTree2(TreeNode source, TreeNode target) {
        //终止条件
        if (source == null && target == null) {
            return true;
        }
        if (source == null || target == null) {
            return false;
        }
        if (source.val != target.val) {
            return false;
        }
        //调用自身
        return doesTree1HasTree2(source.left, target.left) && doesTree1HasTree2(source.right, target.right);
    }
}
