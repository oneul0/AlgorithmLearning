import java.util.*;
import java.io.*;


class Solution
{
	static class Pair {
		int from, to;
		long dist;
		Pair(int from, int to, long dist){
			this.from = from;
			this.to = to;
			this.dist = dist;
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
			bw.write("#"+test_case+" ");
			int n = Integer.parseInt(br.readLine());
			parent = new int[n];
			for(int i = 0; i<n; i++) {
				parent[i] = i;
			}
			int[] x = new int[n];
			int[] y = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			long result = kruskal(x, y, n, E, parent);
			bw.write(result+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a>b) parent[a] =b;
		else parent[b] = a;
	}
	public static long kruskal(int[] x, int[] y, int n, double E, int[] parent) {
		int count = 0;
		long answer = 0;
		List<Pair> edge = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				long dx = (long) x[i] - x[j];
				long dy = (long) y[i] - y[j];
				long dist= dx*dx + dy*dy;
				edge.add(new Pair(i, j, dist));
			}
		}
		Collections.sort(edge, (a,b) -> Long.compare(a.dist, b.dist));
		
		for(Pair next : edge) {
			if(find(next.from) == find(next.to)) continue;
			
			union(next.from, next.to);
			
			answer += next.dist;
			count++;
			
			if(count == n-1) break;
		}
		return Math.round(answer*E);
	}

}