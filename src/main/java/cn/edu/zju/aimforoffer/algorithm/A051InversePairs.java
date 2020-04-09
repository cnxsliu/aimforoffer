package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/8 16:32
 * @strategy
 * 1、先用两个指针分别指向两个子数组的尾部，并每次比较两个指针指向的数字
 * 2、如果第一个子数组中的数字大于第二个子数组中的数字，则构成逆序对，并且逆序对的数组等于
 * 第二个子数组中剩余数字的个数
 * 3、每次比较之后，把较大的数字从后往前复制到一个辅助数组，确保辅助数组中的数字是递增排序的
 * 4、把较大的数字复制到辅助数组之后，把对应的指针向前移动一位
 */
public class A051InversePairs {
    public static int inversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = getCount(array, 0, array.length - 1);
        return count;
    }
    public static int getCount(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        //递归分解
        int mid = (end + start) >> 1;
        int left = getCount(array, start, mid);
        int right = getCount(array, mid + 1, end);
        //合并
        int count = 0;
        int i = mid;
        int j = end;
        int[] temp = new int[end -start + 1];
        //最大索引比长度小1
        int k = end -start;
        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                count += j - mid;
                temp[k--] = array[i--];
            } else {
                temp[k--] = array[j--];
            }
        }
        while (i >= start) {
            temp[k--] = array[i--];
        }
        while (j >= mid + 1) {
            temp[k--] = array[j--];
        }
        for (k = 0; k < temp.length; k++) {
            array[k + start] = temp[k];
        }
        return count + left + right;
    }
    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        System.out.println(inversePairs(array));
    }
}
