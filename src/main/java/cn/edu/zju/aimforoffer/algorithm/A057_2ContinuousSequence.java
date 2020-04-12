package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/12 17:50
 * @strategy
 * 1、定义两个指针left和right，分别指向第一个和第二个元素
 * 2、从left到right的和小于s，增加right
 * 3、从left到right的和大于s，去掉left
 * 4、从left到right的和等于s，将序列元素保存
 * 5、序列最少是两个元素，作为循环结束条件
 */
public class A057_2ContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequece(int sum) {
        ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<>();
        if (sum < 3) {
            return sequenceList;
        }
        int left = 1;
        int right = 2;
        int curSum = left + right;
        while (left <= sum /2) {
            if (curSum == sum) {
                ArrayList<Integer> sequence = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    sequence.add(i);
                }
                sequenceList.add(sequence);
                curSum -= left;
                left++;
            }
            if (curSum < sum) {
                right++;
                curSum += right;
            }
            if (curSum > sum) {
                curSum -= left;
                left++;
            }
        }
        return sequenceList;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequece(15));
    }
}
