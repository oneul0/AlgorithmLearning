import java.io.*;
import java.util.*;

public class Main {
	public static class Edge implements Comparable<Edge> {
		int to;
		int time, cost;

		Edge(int to, int time, int cost) {
			this.to = to;
			this.time = time;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost != o.cost) return this.cost - o.cost;
			return this.time - o.time;
		}
	}

	static int n, t, m, l;
	static List<List<Edge>> gr = new ArrayList<>();

	public static int solve() {
		// minCosts[node][time] = cost
		int[][] minCosts = new int[n + 1][t + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(minCosts[i], Integer.MAX_VALUE);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0, 0));
		minCosts[1][0] = 0;
		int result = Integer.MAX_VALUE;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.to == n) {
				result = Math.min(result, cur.cost);
				continue;
			}
			if (cur.cost > minCosts[cur.to][cur.time]) continue;
			for (Edge next : gr.get(cur.to)) {
				int nextTime = cur.time + next.time;
				int nextCost = cur.cost + next.cost;
				if(nextCost > m) continue;
				if (nextTime <= t) {
					if (minCosts[next.to][nextTime] > nextCost) {
						minCosts[next.to][nextTime] = nextCost;
						pq.offer(new Edge(next.to, nextTime, nextCost));
					}
				}
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String firstLine = br.readLine();
		if(firstLine == null) return;
		n = Integer.parseInt(firstLine);

		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		l = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			gr.add(new ArrayList<>());
		}

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			gr.get(a).add(new Edge(b, time, cost));
			gr.get(b).add(new Edge(a, time, cost));
		}

		System.out.print(solve());
	}
}

