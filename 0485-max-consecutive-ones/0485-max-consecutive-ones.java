class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int sum = 0;
        for(int n : nums){
            if(n == 1) {
                sum+=1;
                ans = Math.max(ans, sum);
            }
            else sum = 0;
        }
        return ans;
    }
}