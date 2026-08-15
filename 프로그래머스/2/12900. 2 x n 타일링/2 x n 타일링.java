class Solution {
    public int solution(int n) {
        int[] dp = new int[Math.max(n,4)+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i<=n; i++){
            dp[i] = (dp[i-1]+ dp[i-2]) % 1_000_000_007;
        }
        return dp[n];
    }
}