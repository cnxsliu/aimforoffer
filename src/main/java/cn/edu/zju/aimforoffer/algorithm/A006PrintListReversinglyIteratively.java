package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/6 19:59
 * @strategy
 * 1、解决这个问题肯定要遍历链表。
 * 2、第一个遍历到的节点最后一个输出，最后一个遍历到节点第一个输出。
 * 3、这就是典型的“后进先出”，可以用栈来实现。
 * 4、而递归的本质就是栈，所以也可以用递归来实现。
 * 5、每访问一个节点，先递归输出它后面的节点，在输出该节点自身。
 * 6、但是，当链表非常长的时候，就会导致函数调用的层级很深，从而导致函数调用栈溢出。
 * 7、显然，用栈基于循环实现的代码鲁棒性要好一些。
 */
public class A006PrintListReversinglyIteratively {
    //用栈来实现
    public ArrayList<Integer> printListReversingly_Iteratively(ListNode headNode){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while(headNode != null){
            stack.push(headNode);
            headNode = headNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }

    //用递归来实现
    public static ArrayList<Integer> printListReversinglyIteratively2(ListNode headNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(headNode != null){
            if(headNode.next != null){
                list = printListReversinglyIteratively2(headNode.next);
            }
            list.add(headNode.val);
        }
        return list;
    }
}
