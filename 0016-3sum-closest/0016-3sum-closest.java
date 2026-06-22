class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = nums[0] + nums[1] + nums[2];

        for(int i = 0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                int need = target - nums[i] -nums[j];

                int l = j+1;
                int r = nums.length-1;
                while(l<=r){
                    int mid = (l+r)/2;

                    int sum = nums[i] + nums[j] + nums[mid];

                    if(Math.abs(sum - target) < Math.abs(answer - target)){
                        answer = sum;
                    }

                    if(nums[mid] < need){
                        l = mid+1;
                    }
                    else{
                        r = mid-1;
                    }
                }
            }
        }

        return answer;
    }
}