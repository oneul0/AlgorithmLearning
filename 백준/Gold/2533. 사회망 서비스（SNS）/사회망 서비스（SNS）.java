import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp;
	static List<Integer>[] tree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		init();
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	public static void dfs(int node) {
		visited[node] = true;
		dp[node][0] = 0;
		dp[node][1] = 1;
		for (int child : tree[node]) {
			if (!visited[child]) {
				dfs(child);
				dp[node][0] += dp[child][1];
				dp[node][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
	}
}
