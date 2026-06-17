class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int t = (l+r) >>> 1;
            if(nums[t] == target) return t;
            else if(nums[t] < target) l = t+1;
            else r = t-1;
        }
        return -1;
    }
}