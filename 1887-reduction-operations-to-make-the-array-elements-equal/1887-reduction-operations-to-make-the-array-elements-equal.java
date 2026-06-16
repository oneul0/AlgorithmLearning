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
//stack으로 돌릴까
//pq 쓰면 pq로만 돌리면 됨
