
import java.util.*;
import java.io.*;

class Solution
{
	static class Edge {
		int to;
		int from;
		int cost;
		Edge(int to, int from, int cost){
			this.to = to;
			this.from = from;
			this.cost = cost;
		}
	}
	static int[] parent;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<Edge> edges = new ArrayList<>();
			parent = new int[V+1];
			for(int i = 1; i<=V; i++) {
				parent[i] = i;
			}
			for(int i = 0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edges.add(new Edge(to, from, cost));
			}
			
			bw.write("#"+test_case+" "+kruskal(edges, V, E)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	static long kruskal(List<Edge> edges, int V, int E) {
		int count = 0;
		long answer = 0;
		Collections.sort(edges, (a,b) -> a.cost - b.cost);
		for(Edge e : edges) {
			if(find(e.to) == find(e.from)) continue;
			union(e.to, e.from);
			count++;
			answer += e.cost;
			if(count == V-1) break;
		}
		return answer;
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a>b) parent[a] =b;
		else parent[b] = a;
	}
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
}