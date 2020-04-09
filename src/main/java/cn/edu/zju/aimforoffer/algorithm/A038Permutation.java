package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/5 17:48
 * @strategy 1、先选择第一个元素：将第一个元素分别和后面每个元素进行交换位置
 * 2、对一个元素后面的元素进行递归
 * 3、注意：在递归之前，交换元素位置，在递归之后还要在交换一次位置，实现还原
 */
public class A038Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return null;
        }
        helper(res, 0, str.toCharArray());
        Collections.sort(res);
        return res;
    }

    private void helper(ArrayList<String> res, int index, char[] s) {
        if (index == s.length - 1) {
            res.add(String.valueOf(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (i == index || s[index] != s[i]) {
                swap(s, index, i);
                helper(res, index + 1, s);
                swap(s, index, i);
            }
        }
    }

    public void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
