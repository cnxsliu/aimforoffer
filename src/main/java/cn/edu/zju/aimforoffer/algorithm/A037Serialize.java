package cn.edu.zju.aimforoffer.algorithm;

import sun.security.krb5.internal.crypto.Des;

import javax.management.DescriptorRead;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/5 17:07
 * @strategy 1、序列化：前序遍历二叉树存入字符串中，左右节点不存在的用"$"代替，各元素之间用","隔开
 * 2、反序列化：根据前序遍历重建二叉树
 */
public class A037Serialize {
    public String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public int index = -1;

    public TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        String[] strArr = str.split(",");
        TreeNode node = null;
        if (index >= len) {
            return null;
        }
        if (!"$".equals(strArr[index])) {
            node = new TreeNode(Integer.valueOf(strArr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
