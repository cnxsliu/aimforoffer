package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/4 17:36
 * @strategy 1、使用递归来搜索
 * 2、定义一个栈，用来保存递归的路径，如果到达叶子节点，该路径中的节点的值的和为目标值，则打印该路径
 * 3、如果叨叨叶子节点，该路径中的节点的值的和不为目标值，则再路径中删除当前节点并减去当前节点的值
 */
public class A034FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(list);
        }
        if (root.left != null) {
            FindPath(root.left, target);
        }
        if (root.right != null) {
            FindPath(root.right, target);
        }

        //递归返回上一层之前的操作
        list.remove(list.size() - 1);

        //listAll实际上在反复使用
        return listAll;
    }
}
