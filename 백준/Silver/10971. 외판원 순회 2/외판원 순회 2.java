import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] W = new int[10][10];
	static long[][] dp = new long[10][65536];
	static int N;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++){
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++){
			Arrays.fill(dp[i], -1);
		}
		System.out.println(tsp(0, 1));
	}

	public static long tsp(int here, int status){
		if(status == (1<<N)-1) return (W[here][0] != 0) ? W[here][0] : Integer.MAX_VALUE;
		if(dp[here][status] != -1) return dp[here][status];
		dp[here][status] = Integer.MAX_VALUE;
		for(int next = 0; next < N; next++){
			if(!hasVisited(status, next) && W[here][next] != 0){
				long newCost = tsp(next, visit(status, next)) + W[here][next];
				if(newCost < dp[here][status]){
					dp[here][status] = newCost;
				}
			}
		}
		return dp[here][status];
	}

	public static boolean hasVisited(int status, int city){
		return (status & (1<<city)) != 0;
	}
	public static int visit(int status, int city){
		return status | (1<<city);
	}
}
