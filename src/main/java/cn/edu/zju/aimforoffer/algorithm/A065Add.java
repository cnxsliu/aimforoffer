package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/18 20:33
 * @strategy
 * 1、先将两个数字按位异或
 * 2、在将两个数字按位与运算，如果不为0，向前进一位，并和步骤1的结果进行循环操作
 */
public class A065Add {
    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));
    }
}
