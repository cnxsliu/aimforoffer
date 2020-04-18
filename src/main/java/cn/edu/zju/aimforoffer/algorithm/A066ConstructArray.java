package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/18 21:00
 * @strategy
 * 1、先从0到n-1遍历，计算B[i]的左半部分
 * 2、定义一个变量temp，计算B[i]的右半部分，从n-1到0遍历
 * 3、然后将B[i]与temp顺次相乘即可
 */
public class A066ConstructArray {
    public static int[] multiply(int[] A) {
        if (A == null || A.length < 2) {
            return null;
        }
        int[] B = new int[A.length];
        int temp = 1;
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i- 1] * A[i - 1];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] = B[i] * temp;
            temp = temp * A[i];
        }
        return B;
    }

    public static int[] multiply2(int[] A) {
        if (A == null || A.length < 2) {
            return null;
        }
        int[] B = new int[A.length];
        int temp = 1;
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i- 1] * A[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {-1, 1, 2, 3, 4, 5, 6};
        int[] B1 = multiply(A);
        int[] B2 = multiply2(A);
        System.out.println("B1");
        for (int i = 0; i < A.length; i++) {
            System.out.print(B1[i]);
        }
        System.out.println();
        System.out.println("B2");
        for (int i = 0; i < A.length; i++) {
            System.out.print(B2[i]);
        }
    }
}
