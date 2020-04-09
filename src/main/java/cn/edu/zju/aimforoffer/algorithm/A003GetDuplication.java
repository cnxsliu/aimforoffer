package cn.edu.zju.aimforoffer.algorithm;
/*
不修改数组找出重复的数字
 */

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/1 22:35
 * @strategy 1、把1~n的数字从中间的数字m分为两部分，前面一半为1~m，后面一半为m+1~n。
 * 2、如果1~m的数字数目超过m，那么这一半的区间里面一定包含重复的数字。
 * 3、否则，另一半m+1~n的区间里面一定包含重复的数字。
 * 4.我们可以继续把包含重复数字的区间一分为二，直到找到一个重复的数字。
 */
public class A003GetDuplication {
}
