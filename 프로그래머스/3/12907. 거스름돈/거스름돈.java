import java.util.*;
class Solution {
    final int INF = 1_000_000_007;
    int[] money;
    public int solution(int n, int[] money) {
        this.money = money;
        // Arrays.sort(this.money);
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int coin : money){
            for(int i = coin; i<=n; i++){
                dp[i] = (dp[i] + dp[i-coin]) %INF;
            }
        }
        
        return dp[n];
    }
}