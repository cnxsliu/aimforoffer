package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/12 17:25
 * @strategy
 * 1、定义两个指针，分别指向第一个数字和最后一个数字
 * 2、如果和大于给定数字和，则将右边数字往左移动一位
 * 3、如果和小于给定数字和，则将左边数字往右移动一位
 */
public class A057_1NumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return list;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (array[left] + array[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumbersWithSum(arr, 15));
    }

}
