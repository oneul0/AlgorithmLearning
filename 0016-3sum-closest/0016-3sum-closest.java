class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = nums[0] + nums[1] + nums[2];

        for(int i = 0; i<nums.length-2; i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[l] + nums[r] + nums[i];

                if(Math.abs(sum - target) < Math.abs(answer - target)){
                    answer = sum;
                }

                if(sum < target){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return answer;
    }
}