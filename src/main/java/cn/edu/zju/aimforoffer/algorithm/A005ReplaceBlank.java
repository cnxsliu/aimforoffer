package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/6 19:49
 * @strategy
 * 1、使用双指针P1和P2.P1指向原始字符串的末尾，P2指向替换之后的字符串的末尾。
 * 2、接下来，向前移动指针P1，逐个把它指向的字符复制到P2指向的位置，直到碰到第一个空格为止。
 * 3、把P1向前移动1格，在P2之前插入“%20”，然后把P2向前移动3格。
 */
public class A005ReplaceBlank {
}
