package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/5 21:37
 * @strategy 1、先将前k个元素放入数组，进行堆排序
 * 2、如果之后有元素比堆顶元素小，则交换他们的值，然后进行调整
 */
public class A040GetLeastNumbers {
    public ArrayList<Integer> getLeastNumers(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        int[] kArray = Arrays.copyOfRange(input, 0, k);
        buildHeap(kArray);
        for (int i = 0; i < input.length; i++) {
            if (input[i] < kArray[0]) {
                kArray[0] = input[i];
                maxHeap(kArray, 0);
            }
        }
        //由于是最大堆，将堆数组中的元素从后往前添加到list中，这样最后list中的元素是有序递增链表
        for (int i = kArray.length - 1; i >= 0; i--) {
            list.add(kArray[i]);
        }
        return list;
    }

    /**
     * 对input数组进行调整，使它成为符合堆结构（完全二叉树）的数组
     *
     * @param input
     */
    public void buildHeap(int[] input) {
        //从后往前添加元素，这样堆顶的元素就会是最大的元素
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            maxHeap(input, i);
        }
    }

    public void maxHeap(int[] array, int i) {
        int left = i * 2 + 1;
        int right = left + 1;
        int largest = 0;
        if (left < array.length && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < array.length && array[right] > array[i]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }
}
