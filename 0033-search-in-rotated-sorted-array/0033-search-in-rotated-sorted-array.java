class Solution {
    public int search(int[] nums, int target) {
        //반복
        //절반 나눠서 target이 있을 수 있는 구간을 찾고
        //그 구간에서 정렬된 구간이고 target이 있을 수 있는 구간을 찾음
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = (l+r)>>>1;
            if(target == nums[m]) return m;
            if(nums[l]<=nums[m]){
                if(nums[l]<=target && target < nums[m]){
                    r = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else {
                if(nums[m]<target && target <= nums[r]){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
        }
        return -1;
    }
}