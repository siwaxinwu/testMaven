package leetcode;

public class MergeSort {
    public void sort(int[] A, int low, int high){
        if (low > high){
            return;
        }
        int mid = low + (high - low)/2;
        sort(A, low, mid);
        sort(A, mid + 1, high);
        merge(A,low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] copy =  nums.clone();

    }
}
