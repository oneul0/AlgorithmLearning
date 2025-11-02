import java.io.*;
import java.util.*;

public class Main {
	static class Pair{
		int to, dist;
		Pair(int to, int dist){
			this.to = to;
			this.dist = dist;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static Map<Integer, List<Pair>> tree = new HashMap<>();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=N; i++){
			tree.put(i, new ArrayList<>());
		}
		StringTokenizer st;
		for(int i = 0; i<N-1; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tree.get(a).add(new Pair(b,c));
			tree.get(b).add(new Pair(a,c));
		}

		Pair answer = bfs(bfs(1).to);
		System.out.println(answer.dist);
	}

	static Pair bfs(int sx){
		Deque<Pair> q = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();

		q.offer(new Pair(sx, 0));
		visited.add(sx);
		Pair farthest = new Pair(sx, 0);
		while(!q.isEmpty()){
			Pair cur = q.poll();
			for(Pair next : tree.get(cur.to)){
				if(!visited.contains(next.to)){
					visited.add(next.to);
					q.offer(new Pair(next.to, next.dist+cur.dist));
					if(farthest.dist < next.dist+cur.dist){
						farthest = new Pair(next.to, next.dist+cur.dist);
					}
				}
			}
		}

		return farthest;
	}
}
