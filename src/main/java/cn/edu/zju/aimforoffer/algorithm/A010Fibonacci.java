package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/10 10:08
 * @strategy
 * 1、使用递归会非常慢，因为有很多重复计算。
 * 2、需要避免重复计算。
 * 3、更简单地办法是从下往上计算。先计算f(0),f(1)，然后算出f(2)，再根据f(1)和f(2)算出f(3)，依次算到第n项。
 */
public class A010Fibonacci {
    public long fibonacii(int n){
        long result = 0;
        long preOne = 1;
        long preTwo = 0;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        for(int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
