package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayDeque;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/14 15:28
 * @strategy
 * 定义一个双端队列来存储队列中的最大值，然后再定义一个双端队列来存储普通的数据
 */
public class A059_2QueueWithMax {
    private class InternalData {
        int number;
        int index;
        public InternalData(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
    private ArrayDeque<InternalData> data = new ArrayDeque<>();
    private ArrayDeque<InternalData> maximum = new ArrayDeque<>();
    private int curIndex;

    public void push_back(int number) {
        InternalData curData = new InternalData(number, curIndex);
        while (!maximum.isEmpty() && maximum.getLast().number < number) {
            maximum.removeLast();
        }
        maximum.addLast(curData);
        data.addLast(curData);
        curIndex++;
    }

    public void pop_front() {
        if (data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if (curData.index == maximum.getFirst().index) {
            maximum.removeFirst();
        }
    }

    public int max() {
        if (maximum == null) {
            System.out.println("队列为空，无法获取！");
            return 0;
        }
        return maximum.getFirst().number;
    }

    public static void main(String[] args) {
        A059_2QueueWithMax queue = new A059_2QueueWithMax();
        queue.push_back(2);
        System.out.println(queue.max() == 2);
        queue.push_back(3);
        System.out.println(queue.max() == 3);
    }
}
