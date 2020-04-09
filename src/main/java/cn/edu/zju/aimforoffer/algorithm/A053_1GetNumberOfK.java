package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/9 18:29
 * @strategy
 * 1、使用二分查找分别找到k的起始位置和终止位置
 * 2、需要分别定义起始位置和终止位置的方法
 */
public class A053_1GetNumberOfK {
    public static int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, 0, array.length - 1, k);
        if (firstK == -1) {
            return 0;
        }
        int lastK = getLastK(array, 0, array.length - 1, k);
        return lastK - firstK + 1;
    }

    private static int getFirstK(int[] arr, int start, int end, int k) {
        if (start > end) {
            return  -1;
        }
        int mid = (start + end) >> 1;
        if (arr[mid] == k) {
            if (mid == 0 || arr[mid - 1] != k) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (arr[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getFirstK(arr, start, end, k);
    }

    private static int getLastK(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (arr[mid] == k) {
            if (mid == (arr.length - 1) || arr[mid + 1] != k) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (arr[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastK(arr, start, end, k);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(arr, 3));
    }
}
