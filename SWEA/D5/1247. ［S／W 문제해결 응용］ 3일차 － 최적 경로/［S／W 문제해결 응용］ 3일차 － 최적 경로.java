import java.util.*;
import java.io.*;

class Solution
{
	static final int INF = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int visitedAll = 0;
			int[][] coords = new int[n+2][];
			coords[0] = new int[] {
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
			};

			coords[n+1] = new int[] {
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
			};
			
			for(int i = 1; i<=n; i++) {
				coords[i] = new int[] {
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
				};
				visitedAll |= (1<<i);
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
			int[][] dist = new int[1<<(n+1)][n+1]; //dist[visited][cur] = min dist
			for(int[] d : dist) {
				Arrays.fill(d, INF);
			}

			pq.offer(new int[] {0, 0, 0}); //node, dist, visited
			dist[0][0] = 0;
			int answer = INF;
			
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				
				if(dist[cur[2]][cur[0]] < cur[1]) continue;
				
				//방문하지 않은 노드가 n+1(집) 노드 밖에 없을 때 거리 구하고 continue
				if(cur[2] == visitedAll) {
					answer = Math.min(answer, 
							getDist(
							coords[cur[0]][0], coords[cur[0]][1]
							,coords[n+1][0], coords[n+1][1]) +cur[1]
									);
					continue;
				}
				//회사와 집을 제외하고 나머지 노드 탐색
				for(int i = 1; i<=n; i++) {
					if((cur[2] & (1<<i)) != 0) continue;
					int nextVisited = cur[2] | (1<<i);					
					
					int newDist = cur[1] + getDist(
							coords[cur[0]][0], coords[cur[0]][1], 
							coords[i][0], coords[i][1]
							);
					//다음 방문 상태 중에서 가장 짧았던 거리가 지금 도달한거리보다 길면

					if(dist[nextVisited][i] > newDist) {
						dist[nextVisited][i] = newDist;
						pq.offer(new int[] {i, newDist, nextVisited});
					}
				}
			}
			bw.write("#"+test_case+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}