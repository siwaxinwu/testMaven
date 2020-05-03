package leetcode;

public class FirstGreaterthan {
    public Integer testFirstGreaterthan(int[] nums, int target, int low, int high){
        if (low > high) {
            return null;
        }
        int middle = low + (high - low)/2;
        if (nums[middle] == target && (middle == 0 || nums[middle -1] < target)) {
            return middle;
        }
        if (target < nums[middle]){
            return testFirstGreaterthan(nums, target, low, middle-1);
        }else {
            return testFirstGreaterthan(nums, target, middle + 1, high);
        }
    }
}
