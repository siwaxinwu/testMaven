package leetcode;

public class TestBinarySearch {
    public int binarySearch(int[] nums, int target, int low, int high){
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low)/2;
        if (nums[middle] == target) {
            return  middle;
        }
        if (target < nums[middle]) {
            return binarySearch(nums, target, low, middle-1);
        } else {
            return binarySearch(nums, target, middle + 1, high);
        }

    }
}
