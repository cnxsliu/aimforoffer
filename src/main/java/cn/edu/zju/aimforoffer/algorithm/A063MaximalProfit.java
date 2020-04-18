package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/18 17:04
 * @strategy
 * 1、遍历每一个数字，并保存之前最小的数字，两者查最大即为最大利润。
 */
public class A063MaximalProfit {
    public static int maxDiff(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            int dif = arr[i] - min;
            if (dif > maxDiff) {
                maxDiff = dif;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(arr));
    }
}
