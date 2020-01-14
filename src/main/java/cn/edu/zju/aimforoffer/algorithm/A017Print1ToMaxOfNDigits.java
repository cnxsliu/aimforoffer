package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/14 22:58
 * @strategy
 * 在字符串上模拟数字加法
 * 1、用字符串或者数组表达大数
 * 2、用字符串表示数字，'0'~'9'之间的某一个字符用来表示数字中的一位
 * 3、定义一个长度为n + 1的字符串，最后一位是结束符号'\0'
 * 4、当实际数字不够n位时，在字符串前半部分补0
 * 5、把字符串中的每一个数字都初始化为'0'
 * 数字排列
 * 1、把数字的每一位都从0~9排列一遍，得到所有的十进制数。
 * 2、排在前面的0不打印出来。
 */
public class A017Print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n + 1];
        number[n] = '\0';
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            A017Print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    private void A017Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if(index == length - 1) {
            PrintNumber(number);
            return;
        }
        for(int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            A017Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    private void PrintNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; i++) {
            if(isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if(!isBeginning0) {
                System.out.printf("%c", number[i]);
            }
        }
        System.out.printf("\t");
    }

}
