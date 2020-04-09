package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/9 17:58
 * @strategy
 * 1、计算两个链表的长度，计算长度差
 * 2、定义两个指针分别指向长链表和短链表，让长链表的指针先走长度差的距离
 * 3、然后两个指针同时走，知道遇到相同的节点，返回即可
 */
public class A052FirstCommonNode {
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        int dif = length1 - length2;
        ListNode longList = pHead1;
        ListNode shortList = pHead2;
        if (dif < 0) {
            longList = pHead2;
            shortList = pHead1;
            dif = -dif;
        }
        for (int i = 0; i < dif; i++) {
            longList = longList.next;
        }
        while (longList != null && longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }

    private static int getLength(ListNode pHead) {
        int len = 0;
        while (pHead != null) {
            len++;
            pHead = pHead.next;
        }
        return len;
    }
}
