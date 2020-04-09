package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/9 21:40
 * @strategy
 * 使用二分查找
 */
public class A053_3GetNumberSameAsIndex {
    public static int getNumberSameAsIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > mid) {
                right = mid - 1;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 3, 5};
        System.out.println(getNumberSameAsIndex(arr));
    }
}
