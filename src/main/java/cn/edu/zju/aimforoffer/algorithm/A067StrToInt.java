package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/18 22:25
 * @strategy
 * 主要是对各种测试用例要考虑清楚：
 * 例如null、空字符串、带有正负号、字符不是数字、溢出等等。
 *
 */
public class A067StrToInt {
    static boolean isValid = false;
    public static int strToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        long num = 0;
        boolean minus = false;
        for(int i = 0; i < str.length(); i++) {
            if (i == 0 && chars[i] == '-') {
                minus = true;
            } else if (i == 0 && chars[i] == '+') {
                minus = false;
            } else {
                int a = chars[i] - '0';
                if (a > 9 || a < 0) {
                    isValid = false;
                    return 0;
                }
                num = (minus == false) ? (num * 10 + a) : (num * 10 - a);
                isValid = true;
                if ((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)) {
                    isValid = false;
                    return 0;
                }
            }
        }
        return (int) num;
    }
}
