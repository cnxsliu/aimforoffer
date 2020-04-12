package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/12 16:17
 * @strategy
 * 1、先将所有数字进行异或，然后在结果数字中找到第一个为1的位的位置n
 * 2、将第n位为1和为0的分成两组，分别进行异或，则各自结果分别为两个只出现一次的结果
 */
public class A056_1NumsAppearOnce {
    public static void findNumsAppearOnce(int[] array, int num1,int num2) {
        if (array == null || array.length < 2) {
            return;
        }
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }
        int indexOf1 = 0;
        while ((resultExclusiveOR & 1) == 0 && (indexOf1 < 4 * 8)) {
            resultExclusiveOR = resultExclusiveOR >> 1;
            indexOf1++;
        }
        num1 = 0;
        num2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (((array[i] >> indexOf1) & 1) == 0) {
                num1 ^= array[i];
            } else {
                num2 ^= array[i];
            }
        }
    }
}
