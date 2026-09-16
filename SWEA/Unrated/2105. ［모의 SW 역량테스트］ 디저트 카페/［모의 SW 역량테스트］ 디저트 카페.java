import java.util.*;
import java.io.*;

class Solution
{
	static int N, sx, sy;
	static int[][] arr;
	static int[] dx = {1,1,-1,-1}, dy= {1,-1,-1,1};
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					sx = i; sy = j;
					boolean[] visited = new boolean[101];
					visited[arr[i][j]] = true;
					result = Math.max(result,  dfs(i, j, 0, 1, arr, visited));
				}
			}
			bw.write("#"+test_case+" "+(result == 0 ? -1 : result)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int dfs(int x, int y, int d, int depth, int[][] arr, boolean[] visited) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx == sx && ny == sy) {
			if(d == 3) return depth;
			return -1;
		}
		
		if(!isValid(nx, ny) || visited[arr[nx][ny]]) return -1;
		int result = -1;
		visited[arr[nx][ny]] = true;
		result = Math.max(result, dfs(nx, ny, d, depth+1, arr, visited));
		if(d < 3) {
			result = Math.max(result, dfs(nx, ny, d+1, depth+1, arr, visited));
		}
		visited[arr[nx][ny]] = false;
		
		return result;
	}
	
	public static boolean isValid(int x, int y) {
		return (x>=0 && y>=0 && x<N && y<N);
	}
	
}