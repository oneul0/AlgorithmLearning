class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n+n];
        for(int i = 0; i<n+n; i++){
            newArr[i] = nums[i%n];
        }
        return newArr;
    }
}