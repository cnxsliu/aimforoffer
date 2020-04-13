package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/13 20:57
 * @strategy
 * 1、字符串分成两部分，先分别对这两部分进行反转，然后再对整体进行反转
 */
public class A058_2LeftRotateString {
    public String leftRotateString(char[] chars, int n) {
        if (chars == null || chars.length <= 0 || n <= 0 || n > chars.length) {
            return String.valueOf(chars);
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[end] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
