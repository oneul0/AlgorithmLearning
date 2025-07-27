import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int tc = 0;

		while(true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			int[][] graph = new int[n][3];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 3; j++){
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println(++tc +". "+dp(n, graph));
		}
	}

	public static int dp(int n, int[][] graph) {
		int[][] dp = new int[n][3];

		dp[0][0] = graph[0][0];
		dp[0][1] = graph[0][1];
		dp[0][2] = graph[0][2] + graph[0][1];
		dp[1][0] = graph[1][0] + dp[0][1];
		dp[1][1] = graph[1][1] + Math.min(dp[0][1], Math.min(dp[0][2], dp[1][0]));
		dp[1][2] = graph[1][2] + Math.min(Math.min(dp[0][1], dp[0][2]), dp[1][1]);

		for(int i = 2; i < n; i++){
			dp[i][0] = graph[i][0] + Math.min(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = graph[i][1] + Math.min(Math.min(dp[i-1][0], dp[i-1][1]), Math.min(dp[i-1][2], dp[i][0]));
			dp[i][2] = graph[i][2] + Math.min(Math.min(dp[i-1][1], dp[i-1][2]), dp[i][1]);
		}
		return dp[n-1][1];
	}
}