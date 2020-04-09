package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/7 18:20
 * @strategy 1、创建一个数组来保存已经找到的丑数
 * 2、定义2,3,5对应的临界位置，小于临界值，肯定小于最大丑数，大于临界值，都大于最大丑数
 * 3、计算2,3,5临界位置的乘以对应的2,3,5后得到的丑数的最小值，更新最大丑数
 * 4、遍历上述步骤，直到第N个
 */
public class A049GetUglyNumber {
    public static int getUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(arr[multiply2] * 2, arr[multiply3] * 3), arr[multiply5] * 5);
            arr[i] = min;
            if (arr[multiply2] * 2 == min) {
                multiply2++;
            }
            if (arr[multiply3 * 3] == min) {
                multiply3++;
            }
            if (arr[multiply5] * 5 == min) {
                multiply5++;
            }
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(2));
    }
}
