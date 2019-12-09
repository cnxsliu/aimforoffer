package cn.edu.zju.aimforoffer.algorithm;
/**
 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列
 都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 个整数，判断数组中是否含有该整数。
 */
/**
 * @author cnxsliu
 * @description 
 * @date 2019/12/9 21:42
 */
public class A003Find {
    public boolean find(int[][] array, int target){
        if(array == null || array.length == 0) {
            return false;
        }

        int left = 0;
        int right = array.length * array[0].length - 1;
        int col = array[0].length;

        while(left <= right){
            int mid = (left + right)/2;
            int value = array[mid / col][mid % col];

            if(value == target){
                return true;
            }else if(value < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

}
