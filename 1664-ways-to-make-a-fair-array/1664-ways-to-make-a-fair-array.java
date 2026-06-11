class Solution {
    public int waysToMakeFair(int[] nums) {
        if(nums.length == 1) return 1;
        int n = nums.length;
        int[] evenSum = new int[n];
        int[] oddSum = new int[n];
        evenSum[0] = evenSum[1] = nums[0];
        oddSum[0] = 0;
        oddSum[1] = nums[1];
        for(int i = 2; i<n; i++){
            if(i%2 == 0){
                evenSum[i] = evenSum[i-1]+nums[i];
                oddSum[i] = oddSum[i-1];
            }
            else{
                oddSum[i] = oddSum[i-1]+nums[i];
                evenSum[i] = evenSum[i-1];
            }
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            int leftEven = (i == 0 ? 0 : evenSum[i-1]);
            int leftOdd  = (i == 0 ? 0 : oddSum[i-1]);

            int rightEven = evenSum[n-1] - evenSum[i];
            int rightOdd  = oddSum[n-1] - oddSum[i];

            int newEven = leftEven + rightOdd;
            int newOdd  = leftOdd + rightEven;

            if (newEven == newOdd) count++;
        }
        return count;
    }
}
//요소 하나를 지울 때
//짝수 인덱스 합과
//홀수 인덱스 합이 같도록
//선택한 인덱스 후로 짝/홀이 뒤집힘