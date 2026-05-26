class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] newArr = new int[nums.length];
        int idx = 0;
        for(int i = 0; i<n; i++){
            newArr[idx++] = nums[i];
            newArr[idx++] = nums[i+n];
        }
        return newArr;
    }
}