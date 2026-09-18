import java.util.*;

public class Main {
    static int n;
    static int[][] cost;
    static int[][] dp;
    static final int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        dp = new int[n][1<<n];

        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.print(dfs(0,1));
    }

    public static int dfs(int cur, int visited){
        if(visited == (1<<n)-1){
            if(cost[cur][0] == 0) return INF;
            return cost[cur][0];
        }
        
        if(dp[cur][visited] != -1){
            return dp[cur][visited];
        }

        dp[cur][visited] = INF;

        for(int next = 0; next<n; next++){

            if((visited & (1<<next)) != 0) continue;
            if(cost[cur][next] == 0) continue;

            int nextVisited = visited | (1<<next);

            dp[cur][visited] = Math.min(dp[cur][visited], cost[cur][next] + dfs(next, nextVisited));
        }
        return dp[cur][visited];
    }


}