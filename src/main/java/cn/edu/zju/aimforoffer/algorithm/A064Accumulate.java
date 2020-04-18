package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/18 17:49
 * @strategy
 * 1、可以考虑的运算符号还有：单目运算符++，--，双目运算符+，-，移位运算符<<，>>，
 * 关系运算符>，<，逻辑运算符&&，||，&，^，赋值=
 * 2、利用逻辑运算符的短路特性：
 * 对于A && B，如果A为假，则不执行B；
 * 对于A || B，如果A为真，则不执行B
 * 3、因此，我们可以用逻辑运算符来代替判断语句
 */
public class A064Accumulate {
    public static int getSum(int n) {
        int sum = n;
        boolean flag = (n > 1) && (sum += getSum(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(getSum(n));
    }
}
