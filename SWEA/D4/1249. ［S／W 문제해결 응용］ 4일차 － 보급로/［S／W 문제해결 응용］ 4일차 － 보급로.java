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
		int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for(int i= 0 ; i<n; i++) {
				String line = br.readLine();
				for(int j = 0; j<n; j++) {
					arr[i][j] = line.charAt(j)-'0';
				}
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(
					(a,b)->a[2]-b[2]);
			int[][] dist = new int[n][n];
			for(int[] d : dist) Arrays.fill(d, INF);
			pq.offer(new int[] {0,0,0});
			dist[0][0] = 0;
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				
				if(cur[2] > dist[cur[0]][cur[1]]) continue;
				
				for(int i =0; i<4; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					int newDist = cur[2]+arr[nx][ny];
					if(dist[nx][ny] <= newDist) continue;
					pq.offer(new int[] {nx, ny, newDist});
					dist[nx][ny] = newDist;
				}
			}
			
			bw.write("#"+test_case+" "+dist[n-1][n-1]+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}