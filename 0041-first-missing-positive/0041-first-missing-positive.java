class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            while (
                nums[i] >= 1 &&
                nums[i] <= nums.length &&
                nums[i] != nums[nums[i]-1]
            ) {
                int val = nums[i];
                nums[i] = nums[val-1];
                nums[val-1] = val;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(i != nums[i]-1) return i+1;
        }
        return nums.length+1;
    }
}

//정렬 안된 정수 배열이 주어질 때, nums에 없는 가장 작은 양수 정수 반환
//상수 시간, 추가 공간 x?
