import java.util.*;
import java.io.*;

class Solution
{
    static final int L = 100;
    static int[] dx = {0,0,-1}, dy = {1,-1,0};
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			br.readLine();
            int[][] arr = new int[L][L];
            int gx = 0, gy = 0;
            for(int i = 0; i<L; i++){
            	st = new StringTokenizer(br.readLine());
                for(int j = 0; j<L; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 2){
                        gx = i;
                        gy = j;
                    }
                }
            }
            bw.write("#"+test_case+" " + solve(arr, gx, gy)+"\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}
    
    public static int solve(int[][] arr, int gx, int gy){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[L][L];
		q.offer(new int[]{gx, gy});
        visited[gx][gy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == 0) return cur[1];
            for(int i = 0; i<3; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || ny<0 || nx>=L || ny>=L || visited[nx][ny] || arr[nx][ny] == 0) continue;
                if(!q.isEmpty()) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;    
            }
        }
        return -1;
    }
    
}