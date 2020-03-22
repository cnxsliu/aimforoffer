package cn.edu.zju.aimforoffer.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/3/22 20:55
 * @strategy
 * 1、对终止行号和起始行号，终止列号和起始列号进行判断
 * 2、注意临界条件
 */
public class A029PrintMatrixClockwiesly {
    public List<Integer> printMatrixClockwisely(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            //从左向右
            for (int c = c1; c <= c2; c++) {
                res.add(matrix[r1][c]);
            }
            //从上向下
            for (int r = r1; r <= r2; r++) {
                res.add(matrix[r][c2]);
            }
            //判断是否重复打印
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    res.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    res.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }

}
