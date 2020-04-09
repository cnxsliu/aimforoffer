package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/5 20:40
 * @strategy 1、对数组进行遍历，如果当前元素和之前的元素相等，count+1，否则count-1
 * 2、当count=1时，保存元素的值
 * 3、还需要额外判断是否存在次数超过一半的数字
 */
public class A039MoreThanHalfNum {
    public int moreThanHalfNum(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return checkMoreThanHalf(nums, candidate) ? candidate : 0;
    }

    public boolean checkMoreThanHalf(int[] nums, int candidate) {
        int times = 0;
        for (int num : nums) {
            if (num == candidate) {
                times++;
            }
        }
        return times * 2 >= nums.length;
    }
}
