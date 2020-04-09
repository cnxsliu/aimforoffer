package cn.edu.zju.aimforoffer.algorithm;

import sun.misc.Queue;

import java.util.ArrayList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/4 15:39
 * @strategy 1、定义一个队列，每次打印一个节点的时候，把这个节点的子节点存放到队列中
 * 2、然后从队列的头部取出最早进入队列的节点
 * 3、重复以上操作，直到队列中的节点都被打印出来
 */
public class A032PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            list.add(node.val);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        return list;
    }
}
