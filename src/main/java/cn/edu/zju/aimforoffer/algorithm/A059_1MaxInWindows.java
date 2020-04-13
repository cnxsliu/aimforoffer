package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/13 22:12
 * @strategy
 * 1、使用双向队列ArrayDeque，先往队列中添加前size个元素
 * 2、之后，将新添加元素与队列最后的一个元素进行比较，如果大于最后一个元素，则删除，直到小于最后一个元素位置
 * 3、将队列的第一个元素取出保存在结果队列中
 */
public class A059_1MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> max = new ArrayList<>();
        if (num == null || num.length <= 0 || size > num.length) {
            return max;
        }
        ArrayDeque<Integer> indexDeque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            if (!indexDeque.isEmpty() && (i - indexDeque.getFirst()) >= size) {
                indexDeque.removeFirst();
            }
            indexDeque.addLast(i);
            max.add(num[indexDeque.getFirst()]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows(arr, 3));
    }
}
