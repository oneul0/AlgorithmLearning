import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int to;
		char color;
		Edge(int to, char color) {
			this.to = to;
			this.color = color;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		char[] cards = new char[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cards[i] = st.nextToken().charAt(0);
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i <= m; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			char color = st.nextToken().charAt(0);
			adj.get(u).add(new Edge(v, color));
			adj.get(v).add(new Edge(u, color));
		}

		// dp[마을번호] = 점수
		int[] dp = new int[m + 1];
		Arrays.fill(dp, -1);
		dp[1] = 0;

		for (int i = 1; i <= n; i++) {
			int[] nextDp = new int[m + 1];
			Arrays.fill(nextDp, -1);

			for (int cur = 1; cur <= m; cur++) {
				if (dp[cur] == -1) continue;
				for (Edge edge : adj.get(cur)) {
					int score = dp[cur] + (edge.color == cards[i] ? 10 : 0);
					nextDp[edge.to] = Math.max(nextDp[edge.to], score);
				}
			}
			dp = nextDp;
		}

		int maxScore = 0;
		for (int i = 1; i <= m; i++) {
			maxScore = Math.max(maxScore, dp[i]);
		}
		System.out.print(maxScore);
	}
}