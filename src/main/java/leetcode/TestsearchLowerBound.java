package leetcode;

public class TestsearchLowerBound {
    public int searchLowerBound(int[] nums, int target, int low, int high){
        if (low > high){
            return -1;
        }
        int middle = low + (high - low)/2;
        if (nums[middle] == target && (middle == 0 || nums[middle -1] < target)) {
            return middle;
        }
        if (target < nums[middle]){
            return searchLowerBound(nums, target, low, middle-1);
        }else {
            return searchLowerBound(nums, target, middle + 1, high);
        }
    }
}
