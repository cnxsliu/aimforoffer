package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/7 17:36
 * @strategy 1、动态规划法，定义一个函数f(i)为以第i个字符为结尾的不含重复字符的子字符串的最大长度
 * 2、当第i个字符之前未出现过，则有：f(i) = f(i - 1) + 1
 * 3、当第i个字符之前出现过，即该字符与上次出现的位置的距离为d
 * 如果d <= f(i - 1)，则f(i) = d
 * 如果d > f(i - 1)，则f(i) = f(i - 1) + 1
 * 4、创建一个长度为26的pos数组用来存放26个字母上次出现的位置
 */
public class A048LongestSubstringWithoutDuplication {
    public static int longestSubstringWithoutDuplication(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int preLength = 0;
        int curLength = 0;
        int maxLength = 0;
        int[] pos = new int[26];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            int letterNumber = str.charAt(i) - 'a';
            if (pos[letterNumber] < 0 || (i - pos[letterNumber]) > preLength) {
                curLength = preLength + 1;
            } else {
                curLength = i - pos[letterNumber];
            }
            pos[letterNumber] = i;
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            preLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("arabcacfr"));
    }
}
