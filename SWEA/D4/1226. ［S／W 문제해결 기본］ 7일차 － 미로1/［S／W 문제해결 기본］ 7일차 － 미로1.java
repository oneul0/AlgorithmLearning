import java.util.*;
import java.io.*;

class Solution
{
    static class Pair {
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            String tmp = br.readLine();
            Pair start = new Pair(0,0);
            Pair end = new Pair(0,0);
            int[][] maze = new int[16][16];
            for(int i = 0; i<16; i++){
                String line = br.readLine();
            	for(int j = 0; j<16; j++){
                    maze[i][j] = line.charAt(j) - '0';
                    
                    if(maze[i][j] == 2){
                        start = new Pair(i, j);
                    }
                    else if(maze[i][j] == 3){
                        end = new Pair(i, j);
                    }
                }
            }
            Queue<Pair> q = new ArrayDeque<>();
            q.offer(start);
            boolean[][] visited = new boolean[16][16];
            visited[start.x][start.y] = true;
            
            while(!q.isEmpty()){
                Pair cur = q.poll();
                
                for(int i = 0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx<0 || ny<0 || nx>=16 || ny>=16 || visited[nx][ny]) continue;
                    if(maze[nx][ny] == 1) continue;
                    q.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            bw.write("#"+test_case+" " +(visited[end.x][end.y] ? 1 : 0)+"\n");
            bw.flush();
		}
        br.close();
        bw.close();
	}
}
