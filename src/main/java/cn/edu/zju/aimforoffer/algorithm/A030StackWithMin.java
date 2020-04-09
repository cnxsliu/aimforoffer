package cn.edu.zju.aimforoffer.algorithm;

import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/22 21:49
 * @strategy 1、定义两个栈，一个用于存储数据，另一个用于存储最小值
 */
public class A030StackWithMin {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else {
            if (min.peek() > node) {
                min.push(node);
            }
        }
    }

    public void pop() {
        int top = data.pop();
        int minTop = min.peek();
        if (top == minTop) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
