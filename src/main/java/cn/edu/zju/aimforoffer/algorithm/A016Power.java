package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/14 22:18
 * @strategy
 * 1、由于精度问题，不能用等号判断两个小数是否相等。
 * 2、代码注意完整性：基本功能、边界值、非法输入。
 * 3、大数问题要用字符串或数组。
 * 4、考虑输入的指数小于1的情况。
 * 5、右移一位代替除以2，用位与运算符代替除余运算符（%）来判断一个数是否是
 */
public class A016Power {
    public double Power(double base, int exponent) {
        double res = 0;
        if(equal(base, 0)) {
            return 0;
        }
        if(exponent == 0) {
            return 1;
        }
        if(exponent > 0) {
            res = multiply(base, exponent);
        }else {
            res = multiply(1/base, -exponent);
        }
        return res;
    }

    public double multiply(double base, int e) {
        double sum = 1;
        for(int i = 0; i < e; i++){
            sum = sum * base;
        }
        return sum;
    }

    public boolean equal(double a, double b) {
        if(a - b < 0.000001 && a - b > -0.000001) {
            return true;
        }
        return false;
    }
}
