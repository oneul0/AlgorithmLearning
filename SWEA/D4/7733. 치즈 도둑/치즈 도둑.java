
import java.util.*;
import java.io.*;

class Solution
{
	static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int maxVal = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxVal = Math.max(maxVal, arr[i][j]);
				}
			}
			
			int maxCount = 0;
			for(int day = 0; day<maxVal; day++) {
				int count = 0;
				boolean[][] visited = new boolean[N][N];
				for(int i = 0; i<N; i++) {
					for(int j = 0; j<N; j++) {
						if(!visited[i][j] && arr[i][j] > day) {
							count++;
							bfs(i, j, day, N, arr, visited);
						}
					}
				}
				maxCount = Math.max(maxCount, count);
			}
			bw.write("#"+test_case+" "+maxCount+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void bfs(int sx, int sy, int day, int N, int[][] arr, boolean[][] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				if(arr[nx][ny] <= day) continue;
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
}