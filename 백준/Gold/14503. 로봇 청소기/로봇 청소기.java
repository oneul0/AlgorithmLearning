import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] room;
	static int cleaned = 0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];

		int sx, sy,d;
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for(int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++){
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		solve(sx, sy, d);
		System.out.println(cleaned);
	}

	public static void solve(int r, int c, int d){
		while(true){
			if(room[r][c] == 0){
				room[r][c] = 2;
				cleaned++;
			}
			if(hasUnCleaned(r, c)){
				for(int i = 0; i<4; i++){
					d = (d+3) % 4;
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(room[nr][nc] == 0){
						r = nr;
						c = nc;
						break;
					}
				}
			}
			else {
				int backr = r - dr[d];
				int backc = c - dc[d];
				if(isValid(backr, backc) && room[backr][backc] != 1){
					r = backr;
					c = backc;
				}
				else{
					return;
				}
			}
		}
	}
	public static boolean hasUnCleaned(int r, int c){
		for(int i = 0; i<4; i++){
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(isValid(nr, nc)){
				if(room[nr][nc] == 0) return true;
			}
		}
		return false;
	}
	public static boolean isValid(int r, int c){
		return (r >=0 && c>=0 && r <n && c<m);
	}
}
