package cn.edu.zju.aimforoffer.algorithm;
/**
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列
 * 都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数。
 */

/**
 * @author cnxsliu
 * @description
 * @date 2019/12/9 21:42
 * @strategy
 * 1、首先，选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束。
 * 2、如果该数字大于要查找的数字，则剔除这个数字所在的列。
 * 3、如果该数字小于呀查找的数字，则剔除这个数字所在的行。
 * 4、也就是说，如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除
 * 一行或者一列，这样每一步都可以缩小查找范围，或者查找范围为空。
 */
public class A004Find {
    public boolean find(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        int row = 0;
        //列数，即第0行的列数-1
        int column = array[0].length - 1;
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}
