package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/10 10:20
 * @strategy
 * 1、对实际问题进行抽象，发现问题并不，，，其实就是一个斐波那契数列。
 * 2、对于边界情况要特殊考虑一下即可。
 */
public class A011JumpFloor {
    public int jumpFloor(int n) {
        if (n < 3) {
            return n;
        }
        int result = 0;
        int preOne = 2;
        int preTwo = 3;
        for (int i = 3; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
