package cn.edu.zju.aimforoffer.algorithm;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/6 21:45
 * @strategy
 * 1、前序遍历的第一个数字1就是根结点。
 * 2、然后扫描中序遍历序列，找到根节点的具体位置。
 * 3、根据中序遍历的特点，在根节点的值1前面的3个数字都是左子节点的值，位于1后面的数字都是右子节点的值
 * 4、同样的，在前序遍历序列中，根节点后面的3个数字就是3个左子树的节点的值，在后面的所有数字都是右子树节点的值。
 * 5、这样我们就在前序遍历和中序遍历两个序列中找到了左、右子树对应的子序列。
 * 6、再用递归的方法分别构建左、右子树即可。
 */
public class A007Construct {
    //代码和文字策略并不一致

    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if(pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        if(pre.length != in.length){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0; i < pre.length; i++){
            if(pre[0] == in[i]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}
