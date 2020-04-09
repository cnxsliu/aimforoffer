package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/7 16:07
 * @strategy 1、f(i) = f(i +1) + g(i, i + 1) * f(i + 2)。
 * 2、当第i位和第i+1位拼接起来的数字在10——25之间的时候，g(i, i + 1)的值为1，否则为0
 * 3、递归时从最大的问题开始自上而下解决问题，存在重复的子问题，可以从最小的问题开始自下而上的解决问题
 */
public class A046GetTranslationCount {
    public static int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }
        String sNumber = String.valueOf(number);
        int len = sNumber.length();
        int[] count = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                count[i] = 1;
            } else {
                count[i] = count[i + 1];
                if (canBeTrans(sNumber, i)) {
                    if (i == len - 2) {
                        count[i] += 1;
                    } else {
                        count[i] += count[i + 2];
                    }
                }
            }
        }
        return count[0];
    }

    public static boolean canBeTrans(String sNumber, int i) {
        int a = sNumber.charAt(i) - '0';
        int b = sNumber.charAt(i + 1) - '0';
        int c = a * 10 + b;
        if (c >= 10 && c <= 25) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(0));
        System.out.println(getTranslationCount(10));
        System.out.println(getTranslationCount(12258));
    }
}
