package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/13 20:27
 * @strategy
 * 1、首先反转整个句子，然后对句子中的每个单词进行反转
 * 2、需要仙女使用前后指针，交换指针位置的元素，知道两个指针相遇
 */
public class A058_1ReverseSentence {
    public String reverseSentence(char[] chars) {
        if (chars == null || chars.length <= 0) {
            return String.valueOf(chars);
        }
        int start = 0;
        int end = 0;
        while (start < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            reverseSb(chars, start, end - 1);
            start = ++end;
        }
        return String.valueOf(chars);
    }

    private void reverseSb(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
