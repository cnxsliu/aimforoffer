package cn.edu.zju.aimforoffer.algorithm;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/16 17:34
 * @strategy
 * 1、先对5张 牌进行排序
 * 2、找出0的个数
 * 3、计算相邻元素的空缺总数
 * 4、判断0的个数是否大于空缺总数，如果是则连续，否则不连续
 * 5、如果相邻元素相等，则不相等
 */
public class A062IsContinuous {
    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 5, 4};
        System.out.println(isContinuous(arr));
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }
        Arrays.sort(numbers);
        int numberOf0 = 0;
        int numberOfGap = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                break;
            }
            numberOf0++;
        }
        int small = numberOf0;
        int big = numberOf0 + 1;
        for (int i = small; i < numbers.length - 1; i++) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numberOfGap += numbers[big++] - numbers[small++] -1;
        }
        if (numberOf0 < numberOfGap) {
            return false;
        }
        return true;
    }
}
