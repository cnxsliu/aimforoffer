package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/6 17:27
 * @strategy 1、每一位进行处理，不断遍历每一位
 * 2、如果该位为0，则该位为1的次数由高位决定
 * 3、如果该位为1，则该位为1的次数由高位和低位决定
 * 4、如果该位大于0，则该位为1的次数由高位决定
 */
public class A043NumberOf1Between1AndN {
    public int numberOf1Between1AndN(int n) {
        int count = 0;
        int i = 1;
        int current, after, before = 0;
        while ((n / i) != 0) {
            //高位
            before = n / (i * 10);
            //当前位
            current = (n / i) % 10;
            //低位
            after = n - (n / i) * i;
            if (current == 0) {
                count = count + before * i;
            } else if (current == 1) {
                count = count + before * i + after + 1;
            } else {
                count = count + (before + 1) * i;
            }
            i = i * 10;
        }
        return count;
    }
}
