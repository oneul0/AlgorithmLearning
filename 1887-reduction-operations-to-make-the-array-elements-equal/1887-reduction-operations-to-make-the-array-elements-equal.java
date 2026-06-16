class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int diffCount = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i-1]) diffCount++;
            count+=diffCount;
        }
        return count;
    }
}

//업데이트별로 정렬하면 시간 터짐
//가장 작은 수 제외하고 서로 다른 수가 몇 개 있는지
