import java.io.*;
import java.util.*;

public class Main {
    static int n, result;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        visited = new boolean[n][n];
        for(int i =0 ; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    result = 0;
                    dfs(i, j);
                    pq.offer(result);
                }
            }
        }
        
        bw.write(pq.size()+"\n");
        while(!pq.isEmpty()){
            bw.write(pq.poll()+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int x, int y){
        result+=1;
        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
            if(visited[nx][ny] || grid[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
}