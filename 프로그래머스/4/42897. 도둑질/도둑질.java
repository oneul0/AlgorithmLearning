import java.util.*;
class Solution {
    int[] money;
    public int solution(int[] money) {
        this.money = money;
        return Math.max(rob(0,money.length-2), rob(1,money.length-1));
    }
    int rob(int start, int end){
        int[] dp = new int[money.length];
        
        dp[start] = money[start];
        dp[start+1] = Math.max(money[start], money[start+1]);
        
        for(int i = start+2; i<=end; i++){
            if(dp[i] == 0){
                dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
            }
        }
        return dp[end];
    }
}