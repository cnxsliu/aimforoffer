package cn.edu.zju.aimforoffer.algorithm;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/12 17:09
 * @strategy
 * 1、把数组中所有数字的二进制表示的每一位都加起来，如果某一位的和能被3整除，那么
 * 那个只出现一次的数字二进制表示中对应的那一位是0，否则是1.
 */
public class A056_2NumberApppearingOnce {
    public static int findNumberAppearingOnce(int[] arr) {
        if (arr == null || arr.length == 0)  {
            throw new RuntimeException();
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < 32; i++) {
            bitSum[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 31; j > 0; j--) {
                int bit = arr[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,-1,-1,-1,2};
        System.out.println(findNumberAppearingOnce(arr));
    }
}
