package cn.edu.zju.aimforoffer.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/6 15:37
 * @strategy 1、将数据分成两部分，用一个最大堆实现左边的数据容器，用最小堆实现右边的数据容器
 * 2、用优先队列来实现最小堆，最大堆（最大堆需要自定义一个比较器）
 * 3、当数据为奇数个时，将元素存到最大堆（先放到最小堆，再把最小堆的最小值放到最大堆）；
 * 4、当数据为偶数个，将元素存到最小堆（先放到最大堆，再把最大堆的最大值放到最小堆）；
 */
public class A041StreamMedian {
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, new
            Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

    public void insert(Integer num) {
        count++;
        //如果是奇数，将元素存到最大堆
        if ((count & 1) == 1) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.peek());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.peek());
        }
    }

    public Double getMedian() {
        if (count == 0) {
            return null;
        }
        if ((count & 1) == 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return Double.valueOf((minHeap.peek() + maxHeap.peek()) / 2);
        }
    }
}
