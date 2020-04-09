package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/2/23 17:06
 * @strategy 1、E/e后面不能有小数点
 * 2、除了第一位的+/-，其余的都必须是前一位是E/e
 */
public class A020IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        //字符的位置
        int index = 0;
        //e/E的个数
        int ecount = 0;
        //小数点的个数
        int point = 0;

        //第一个字符是-/+
        if (str[0] == '-' || str[0] == '+') {
            index++;
        }

        for (int i = index; i < str.length; i++) {
            if (str[i] == '-' || str[i] == '+') {
                if (str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                continue;
            }
            if (str[i] == 'e' || str[i] == 'E') {
                ecount++;
                if (ecount > 1) {
                    return false;
                }
                if (i == 0 || str[i - 1] < 48 || str[i - 1] > 57 || i == str.length - 1) {
                    return false;
                }
                point++;
                continue;
            }
            if (str[i] == '.') {
                point++;
                if (point > 1) {
                    return false;
                }
                continue;
            }
            if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E')) {
                return false;
            }
        }
        return true;
    }
}
