
import java.util.*;
import java.io.*;

class Solution
{
	static int[] dx = {-1,1,0,0}, dy= {0,0,-1,1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception
	{

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			br.readLine();
			int[][] arr = new int[100][100];
			
			int sx = -1, sy = -1;
			for(int i = 0; i<100; i++) {
				String line = br.readLine();
				for(int j = 0; j<100; j++) {
					arr[i][j] = line.charAt(j) - '0';
					if(arr[i][j] == 2) {
						sx = i;
						sy = j;
					}
				}
			}
			
			bw.write("#"+test_case+" "+bfs(sx, sy, arr)+ "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static int bfs(int sx, int sy, int[][] arr) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[100][100]			;
		q.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		
		while(!q.isEmpty()){
			int[] cur = q.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx<0 || ny<0 || nx>=100 || ny>=100 || visited[nx][ny]) continue;
				if(arr[nx][ny] == 1) continue;
				if(arr[nx][ny] == 3) {
					return 1;
				}
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		return 0;
	}
}