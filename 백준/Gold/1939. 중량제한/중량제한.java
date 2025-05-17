import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M;
	static int start, goal;
	static List<List<int[]>> gr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i = 0; i<=N; i++){
			gr.add(new ArrayList<>());
		}

		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			gr.get(a).add(new int[]{b,c});
			gr.get(b).add(new int[]{a,c});
		}

		st = new StringTokenizer(br.readLine());
		br.close();
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());

		System.out.printf(dijkstra()+"");
	}

	static int dijkstra() {
		int[] maxWeight = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost); // 내림차순

		pq.offer(new Node(start, Integer.MAX_VALUE));
		maxWeight[start] = Integer.MAX_VALUE;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.to;

			if (visited[now]) continue;
			visited[now] = true;

			for (int[] next : gr.get(now)) {
				int to = next[0];
				int weight = next[1];

				int minWeight = Math.min(maxWeight[now], weight);
				if (maxWeight[to] < minWeight) {
					maxWeight[to] = minWeight;
					pq.offer(new Node(to, minWeight));
				}
			}
		}

		return maxWeight[goal];
	}
	
}

class Node{
	int to, cost;
	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
}