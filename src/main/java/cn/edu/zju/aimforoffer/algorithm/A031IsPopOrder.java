package cn.edu.zju.aimforoffer.algorithm;

import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/4 15:14
 * @strategy 1、定义一个辅助栈，如果下一个弹出的元素刚好是栈顶元素，直接弹出；
 * 2、如果弹出的元素不是栈顶元素，则把压栈序列中还没有入栈的数字压入辅助栈，直到下一个需要弹出的数字压入栈顶为止
 * 3、如果压栈序列所有的数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不肯能是一个弹出序列。
 */
public class A031IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
