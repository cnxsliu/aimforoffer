package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/9 21:06
 * @strategy
 * 1、使用二分查找法
 * 2、如果中间元素等于下标，将左节点一到中间右边一位
 * 3、如果中间元素不等于下标，（1）如果前一个元素等于其下标或者当前下标为0，则返回当前中间元素下标
 * （2）如果前一个元素不等于其下标，则将右节点移到中间节点左边一位
 *
 * 注意：循环条件是left <= right，不要忘了等于号
 */
public class A053_2MissingNumber {
    public static int getMissingNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] != mid) {
                if (mid == 0 || arr[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4};
        System.out.println(getMissingNumber(arr));
    }
}
