package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/1/10 14:47
 * @strategy
 * 1、使用回溯法。
 * 2、机器人从（0,0）开始移动。
 * 3、当进入（i，j）时，通过检查坐标的位数和来判断机器人是否能够进入。
 * 4、如果能够进入，在判断它能够进入4个相邻的格子。
 */
public class A013MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) {
            return 0;
        }
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold) + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        while(i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
