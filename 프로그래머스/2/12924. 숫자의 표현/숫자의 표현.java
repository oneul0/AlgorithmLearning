class Solution {
    public int solution(int n) {
        int[] prefixSum = new int[n+1];
        for(int i =1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + i;
        }
        int answer = 0;
        int l = 0, r = 1;
        while(l<=r && r<=n){
            int curSum = prefixSum[r] - prefixSum[l];
            if(curSum > n){
                l++;
            }
            else if(curSum < n){
                r++;
            }
            else {
                answer++;
                r++;
            }
        }
        return answer;
    }
}