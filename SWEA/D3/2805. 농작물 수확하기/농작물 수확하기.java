import java.util.*;
import java.io.*;

class Solution
{
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());

            int[][] farm = new int[N][N];
            for(int i = 0; i<N; i++){
                String line = br.readLine();
                for(int j = 0; j<N; j++){
                    farm[i][j] = line.charAt(j)-'0';
                }
            }

            int sx = N/2;
            int sy = N/2;

            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];
            q.offer(new int[]{sx, sy, N/2});
            visited[sx][sy] = true;
            int val = farm[sx][sy];
            while(!q.isEmpty()){
                int[] cur = q.poll();
                if(cur[2] <= 0) continue;
                for(int i = 0; i<4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
                    q.offer(new int[]{nx, ny, cur[2]-1});
                    visited[nx][ny] = true;
                    val += farm[nx][ny];
                }
            }
            bw.write("#"+test_case+" "+val+"\n");
		}
        bw.flush();
        br.close();
        bw.close();

	}
}