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
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int i = 0; i<V; i++){
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			tree.putIfAbsent(cur, new ArrayList<>());

			while(true){
				int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
				int dist = Integer.parseInt(st.nextToken());
				tree.putIfAbsent(node, new ArrayList<>());
				tree.get(cur).add(new Pair(node, dist));
				tree.get(node).add(new Pair(cur, dist));
			}
		}

		Pair answer = bfs(bfs(1, V).to, V);
		System.out.println(answer.dist);
	}

	static Pair bfs(int sx, int V){
		Deque<Pair> q = new ArrayDeque<>();
		boolean[] chk = new boolean[V+1];
		q.offer(new Pair(sx, 0));
		chk[sx] = true;
		Pair farthestNode = new Pair(sx,0);
		while(!q.isEmpty()){
			Pair cur = q.poll();

			for(Pair next : tree.get(cur.to)){
				if(!chk[next.to]){
					int nextNode = next.to;
					int newDist = cur.dist+ next.dist;
					chk[nextNode] = true;
					q.offer(new Pair(nextNode, newDist));
					if(newDist > farthestNode.dist){
						farthestNode = new Pair(nextNode, newDist);
					}
				}
			}
		}
		return farthestNode;
	}

}
