class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k-1);
    }
    public int quickSelect(int[] nums, int left, int right, int k){
        int pivotIdx = partition(nums, left, right);
        if(pivotIdx == k) return nums[pivotIdx];
        else if(k < pivotIdx) return quickSelect(nums,left, pivotIdx-1, k);
        else return quickSelect(nums, pivotIdx+1, right, k);
    }
    public int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int i = left;
        for(int j = left; j<right; j++){
            if(nums[j] > pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);

        return i;
    }
    public void swap(int[] nums, int i, int j){
        int tmp= nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}