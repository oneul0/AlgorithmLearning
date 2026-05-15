class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for(int len = 1; len<=n; len++){
            for(int left = 0; left+len-1<n; left++){
                int right = left + len-1;
                if(s.charAt(left) == s.charAt(right)){
                    if(len <= 2){
                        isPal[left][right]= true;
                    }
                    else{
                        isPal[left][right] = isPal[left+1][right-1];
                    }
                }
            }
        }

        int[] dp = new int[n+1];
        for(int end = 1; end<=n; end++){
            dp[end] = dp[end-1];
            for(int start =0; start<=end-k; start++){
                if(isPal[start][end-1]){
                    dp[end] = Math.max(dp[end], dp[start]+1);
                }
            }
        }
        return dp[n];
    }
}