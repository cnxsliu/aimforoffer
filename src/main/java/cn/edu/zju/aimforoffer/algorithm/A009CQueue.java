package cn.edu.zju.aimforoffer.algorithm;

import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/6 22:45
 * @strategy 1、当stack2不为空时，在stack2中的栈顶元素是最先进入队列的元素，可以弹出。
 * 2、当stack2为空时，把stack1中的元素逐个弹出并压入stack2。
 * 3、在插入一个新的元素的时候，还是把它压入stack1。
 */
public class A009CQueue {
    Stack stack1;
    Stack stack2;

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈为空！");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return (int) stack2.pop();
    }
}
