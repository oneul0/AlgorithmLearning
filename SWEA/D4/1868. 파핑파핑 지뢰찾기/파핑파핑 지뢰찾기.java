import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static char[][] board;
	static boolean[][] visited;
	static int[][] mineCnt;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int result = 0;
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			mineCnt = new int[N][N];
			visited= new boolean[N][N];
			for(int i = 0; i<N; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			for(int i = 0; i<N; i++) {
				for(int j =0; j<N; j++) {
					if(board[i][j] == '*') continue;
					
					for(int d = 0; d<8; d++) {
						int nx = i+dx[d];
						int ny = j +dy[d];
						
						if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
						
						if(board[nx][ny] == '*') mineCnt[i][j]++;
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(board[i][j] == '.' && mineCnt[i][j] == 0 && !visited[i][j]) {
						result++;
						bfs(i, j);
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(board[i][j] == '.' && !visited[i][j]) {
						result++;
					}
				}
			}
			
			bw.write("#"+test_case+" "+result+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void bfs(int sx, int sy) {
		Queue<int[]> q= new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		visited[sx][sy]=true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d<8; d++) {
				int nx = cur[0]+dx[d];
				int ny = cur[1]+dy[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				if(board[nx][ny] == '*') continue;
				
				visited[nx][ny] = true;
				if(mineCnt[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}

}
//지뢰 없는 칸을 최대한 많이 갖고 있는 칸 누르기
//패딩해서 가장 가장자리의 내용도 찾을 수 있게  
