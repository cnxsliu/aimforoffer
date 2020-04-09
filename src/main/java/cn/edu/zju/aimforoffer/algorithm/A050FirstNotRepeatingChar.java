package cn.edu.zju.aimforoffer.algorithm;

import java.util.LinkedHashMap;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/7 20:46
 * @strategy 1、利用LinkedHashMap来保存字符和出现的子树
 * 2、第一次遍历，将每个元素的出现次数保存
 * 3、第二次遍历，找到第一个出现次数为1的元素
 */
public class A050FirstNotRepeatingChar {
    public static char firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return '\0';
        }
        char[] strArr = str.toCharArray();
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<>();
        for (char item : strArr) {
            if (hash.containsKey(item)) {
                hash.put(item, hash.get(item) + 1);
            } else {
                hash.put(item, 1);
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            if (hash.get(strArr[i]) == 1) {
                return strArr[i];
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
        System.out.println(firstNotRepeatingChar("aabbcc"));
    }
}
