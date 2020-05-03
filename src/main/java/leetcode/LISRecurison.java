package leetcode;

/**
 *  寻找一个数组的最长上升子序列的长度，f（n）是以nums[n-1]为结尾的最长上升子序列的长度
 *  f（n） = max（f（i）） + 1
 *  n = nums.length
 *
 */
public class LISRecurison {
    static int max;
    public int f(int[] nums, int n){
        if (n <= 1) {
            return  n;


        }
        int result = 0;
        int maxEndingHere = 1;
        for (int i = 0; i < n; i++) {
            result = f(nums, i);
            if (nums[i -1] < nums[n - 1] && result + 1 > maxEndingHere) {
                maxEndingHere = result + i;
            }
        }
        if (max < maxEndingHere){
            max = maxEndingHere;
        }
        return maxEndingHere;
    }
    public int LIS(int[] nums){
        max = 1;
        f(nums, nums.length);
        return  max;
    }

}
