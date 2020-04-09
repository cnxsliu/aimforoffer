package cn.edu.zju.aimforoffer.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/6 22:53
 * @strategy 1、将整数数组转换成String数组，然后将String数组排序，最后将字符串数组中的字符串拼接出来
 * 2、关键是定义比较规则
 */
public class A045PrintMinNumber {
    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
