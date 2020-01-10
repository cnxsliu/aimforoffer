package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/10 11:22
 * @strategy
 * 1、使用回溯法。
 * 2、假设矩阵中某个格子的字符为ch，并且对应字符串的第i个字符。
 * 3、如果第i个字符不是ch，那么这个格子布可能处在第i个位置上。
 * 4、如果路径上的第i个字符正好是ch，到相邻的格子寻找路径上的第i+1个字符。
 * 5、由于回溯法的递归特性，路径可以被看成是一个栈。
 * 6、如果第n个字符对应的格子周围都没有找到第n+1个字符，这时候只好在路径上回到第n-1个字符，重新定位。
 * 7、由于路径不能重复进入矩阵，所以还要定义和字符矩阵大小一样的布尔矩阵。
 */
public class A012HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(helper(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return true;
    }
    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j>= cols || matrix[index] != str[k] || flag[index] == 1) {
            return false;
        }
        if(k == str.length - 1) {
            return true;
        }
        flag[index] = 1;
        if(
                helper(matrix, rows, cols, i - 1, j, str, k + 1, flag) ||
                helper(matrix, rows, cols, i + 1, j, str, k + 1, flag) ||
                helper(matrix, rows, cols, i, j - 1, str, k + 1, flag) ||
                helper(matrix, rows, cols, i, j + 1, str, k + 1, flag))
        {
            return true;
        }
        flag[index] = 0;
        return false;
    }
}
