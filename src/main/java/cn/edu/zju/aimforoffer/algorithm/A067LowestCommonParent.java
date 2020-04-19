package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/19 21:42
 * @strategy
 * 1、树为二叉搜索树，最低公共祖先节点的大小再两个树节点大小的中间
 * 2、树为普通树，使用遍历将子节点的信息网上传递。在左右子节点中进行查找是否存在两个树节点，
 * 如果树节点分别在左右子树上，说明该节点是他们的最低公共祖先。
 */
public class A067LowestCommonParent {
    public TreeNode getLowestCommonParentBST(TreeNode root, TreeNode node1, TreeNode node2) {
        while (true) {
            if (root == null) {
                return null;
            }
            if (root.val < node1.val && root.val < node2.val) {
                root = root.right;
            }
            else if (root.val > node1.val && root.val > node2.val) {
                root = root.left;
            }
            else {
                return root;
            }
        }
    }

    public TreeNode getLowestCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        TreeNode left = getLowestCommonParent(root.left, node1, node2);
        TreeNode right = getLowestCommonParent(root.right, node2, node2);
        return left == null ? right : right == null ? left : root;
//        上面这句的意思是：
//         if (left == null) {
//             return right;
//         }
//         else if(right == null) {
//             return left;
//         }
//         else {
//             return root;
//         }
    }
}
