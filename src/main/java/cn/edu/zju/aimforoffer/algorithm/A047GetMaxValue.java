package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/7 17:10
 * @strategy 1、定义一个数组，用来存储每一行的价值最大的走法的价值和
 * 2、计算下一行的价值最大的走法的价值和，该行每一个位置的最大价值和取决于上边和左边的位置的大小比较
 * 3、当是最左边或者最上边的时候，不需要进行比较
 * 4、遍历完成之后返回存储数组的最后一个元素
 */
public class A047GetMaxValue {
    public static int getMaxValue(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int rows = values.length;
        int cols = values[0].length;
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValues[j];
                }
                if (j > 0) {
                    left = maxValues[j - 1];
                }
                maxValues[j] = Math.max(up, left) + values[i][j];
            }
        }
        return maxValues[cols - 1];
    }

    public static void main(String[] args) {
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(getMaxValue(values));
    }
}
