package cn.edu.zju.aimforoffer.algorithm;

import java.text.NumberFormat;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/14 16:46
 * @strategy
 * 1、用两个数组来存储骰子点数的每个总数出现的次数
 * 2、在一轮循环中，第一个数组中的第n个数字表示骰子和为n出现的次数。
 * 3、下一轮循环中，加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一轮中骰子点数
 * 和为n-1,n-2,n-3,n-4,n-5,n-6的次数的总和
 */
public class A060PrintProbability {
    private static final int maxValue = 6;
    public static void printProbability(int number) {
        if (number <= 0) {
            return;
        }

        int[][] probabilities = new int[2][number * maxValue + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < number * maxValue; j++) {
                probabilities[i][j] = 0;
            }
        }
        for (int i = 1; i <= 6; i++) {
            probabilities[0][i] = 1;
        }

        int flag = 0;
        for (int curNumber = 0; curNumber <= number; curNumber++) {
            //前面的数据清零
            for (int i = 0; i < curNumber; i++) {
                probabilities[1 - flag][i] = 0;
            }
            for (int i = curNumber; i <= curNumber * maxValue; i++) {
                for (int j = 1; j <= 6 && j <= i; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        int totalP = (int) Math.pow(maxValue, number);
        double all = 0;
        for (int i = number; i <= number * maxValue; i++) {
            double  ratio = (double) probabilities[flag][i] / totalP;
            NumberFormat  format = NumberFormat.getPercentInstance();
            //设置保留几位小数
            format.setMaximumFractionDigits(8);
            System.out.println("点数和为：" +(i) + "的概率为：" + format.format(ratio));
        }
    }

    public static void main(String[] args) {
        printProbability(3);
    }
}
