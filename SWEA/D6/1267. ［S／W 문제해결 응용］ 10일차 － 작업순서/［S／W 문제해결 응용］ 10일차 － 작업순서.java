
import java.util.*;
import java.io.*;

class Solution
{
	static int[] dx = {-1,1,0,0}, dy= {0,0,-1,1};
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception
	{

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> gr = new ArrayList<>();
			for(int i = 0; i<=V; i++) {
				gr.add(new ArrayList<>());
			}
			int[] inbound = new int[V+1];
			
			st=  new StringTokenizer(br.readLine());
			for(int i = 0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				inbound[to]++;
				gr.get(from).add(to);
			}
			
			
			
			bw.write("#"+test_case+" ");
			int[] result = solve(inbound, gr, V);
			for(int i = 0; i<V; i++) {
				bw.write(result[i]+" ");
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static int[] solve(int[] inbound, List<List<Integer>> gr, int V) {
		int idx = 0;
		int[] result=new int[V+1];
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[V+1];
		for(int i = 1; i<=V; i++) {
			if(inbound[i] == 0) {
				q.offer(i);
				visited[i] = true;
				result[idx++] = i;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : gr.get(cur)) {
				inbound[next]--;
				if(inbound[next] == 0 && !visited[next]) {
					q.offer(next);
					visited[next] = true;
					result[idx++] = next;
				}
			}
		}

		return result;
	}
}
