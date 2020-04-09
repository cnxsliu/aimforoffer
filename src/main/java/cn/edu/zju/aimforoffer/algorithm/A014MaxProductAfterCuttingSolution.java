package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/14 20:32
 * @strategy 动态规划
 * 1、首先定义函数f(n)为把长度为n的绳子剪成若干段后各段长度乘积的最大值。
 * 2、在剪第一刀的时候，有n-1种可能的选择，即1,2，...，n-1。因此f(n) = max(f(i)*f(n-1))
 * 3、这是一个从上至下的递归公式，有很多重复的子问题，改为按照从下而上的顺序计算。
 * 4、f(2) = 1，f(3) = 2
 * 贪婪算法
 * 1、当n>=5时，我们尽可能多地剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
 * 2、2(n-2)>n且3(n-3)>n，当n>=5时，3(n-3)>=2(n-2)，很容易用n > 5推导出来。
 */
public class A014MaxProductAfterCuttingSolution {

    /**
     * 动态规划
     *
     * @param length
     * @return
     */
    public int maxProductAfterCuttingSolution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    /**
     * 贪婪算法
     *
     * @param length
     * @return
     */
    public int maxProductAfterCuttingSolution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timeOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * (int) (Math.pow(2, timeOf2)));
    }
}
