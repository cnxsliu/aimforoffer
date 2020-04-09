package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/6 16:01
 * @strategy 1、对数组进行遍历，如果和小于0，则将最大值设置为当前值，否则计算最大和
 */
public class A042FindeGreatestSumOfSubArray {
    public int maxSubArray(int[] nums) {
        //数组为空，或者数组长度为0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int result = nums[0];
        for (int num : nums) {
            result = result > 0 ? result + num : num;
            max = Math.max(result, max);
        }
        return max;
    }
}
