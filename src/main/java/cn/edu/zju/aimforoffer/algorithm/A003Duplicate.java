package cn.edu.zju.aimforoffer.algorithm;
/*
找出数组中重复的数字
 */

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/1 22:29
 * @strategy 1、从头到尾扫描数组中的每个数字。
 * 2、当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i。
 * 3、如果是，则接着扫描下一个数字。
 * 4、如果不是，则再拿它和第m个数字进行比较。
 * 5、如果它和第m个数字相等，就找到了一个重复的数字。
 * 6、如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置。
 * 7、接下来重复这个比价、交换的过程，直到发现一个重复的数字。
 */
public class A003Duplicate {
}
