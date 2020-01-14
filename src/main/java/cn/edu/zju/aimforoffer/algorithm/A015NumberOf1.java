package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/14 21:24
 * @strategy
 * 常规解法
 * 1、先判断整数二进制表示中最后一为是不是1，用1与该二进制表示做与运算，看结果是否等于0
 * 2、然后把判断数1不断左移，继续与二进制表示做与运算，看结果是否等于0
 *
 * 好的解法
 * 1、把一个整数减去1，再和原整数做与运算，就会把该整数最右边的1变成0。
 * 2、只要n不是0，就表明n还有1存在，继续上一步操作。
 */
public class A015NumberOf1 {
    /**
     * 好的解法
     * @param n
     * @return
     */
    public int A015NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
    public int A015NumberOf2(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0) {
            if((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
