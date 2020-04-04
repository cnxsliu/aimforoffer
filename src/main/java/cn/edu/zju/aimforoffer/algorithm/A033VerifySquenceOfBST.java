package cn.edu.zju.aimforoffer.algorithm;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/4 16:47
 * @strategy
 * 1、最后一个数字是树的根节点的值
 * 2、左子树都比根节点小，右节点都比根节点大，将数组二分
 * 3、分别对上面的左右子树进行递归
 * 4、如果出现左子树节点大于根节点或者右子树节点小于根节点，证明不是二叉搜索树；否则就是
 */
public class A033VerifySquenceOfBST {
    public boolean VerifySquenceOfBST (int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int rstart = 0;
        int rootIndex = sequence.length - 1;
        for (int i = 0; i < rootIndex; i++) {
            if (sequence[i] < sequence[rootIndex]) {
                rstart++;
            }
        }
        if (rstart == 0) {
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rootIndex));
            return true;
        }

        //递归结束条件
        for (int i = rstart; i < rootIndex; i++) {
            if (sequence[i] <= sequence[rootIndex]) {
                return false;
            }
        }
        VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rootIndex));
        VerifySquenceOfBST(Arrays.copyOfRange(sequence, rstart, rootIndex));
        return true;
    }
}