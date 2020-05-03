package leetcode;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 *冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] nums){
        boolean haschange = true;
        for (int i = 0; i < nums.length - 1 && haschange; i++) {
            haschange = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]){
                    swap(nums, j, j + 1);
                    haschange = true;

                }
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        if (nums[j] > nums[i]){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 12, 1, 56, 24};
        System.out.println("冒泡排序前：" + Arrays.toString(nums));
        sort(nums);
        System.out.println("冒泡排序后：" + Arrays.toString(nums));
    }
}
