package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/14 15:03
 * @strategy
 * 1、定义两个指针，一个指向数组第一个位置，一个指向数组最后一个位置
 * 2、左边的指针不断向右移动，直到遇到偶数，右边的指针不断向左移动，直到遇到奇数，然后交换指针位置元素。
 */
public class A021ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 0;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }
}
