import java.io.*;
import java.util.*;
public class Main {
    static int n, m,K;
    static int[][] grid;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                K = Math.max(K, grid[i][j]);
            }
        }
        //K++
        int ansK = K;
        int maxCount = 0;
        for(int k = 1; k<K; k++){
            int count = 0;
            boolean[][] visited= new boolean[n][m];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(!visited[i][j] && k<grid[i][j]){
                        count++;
                        bfs(i, j, visited, k);
                    }
                }
            }
            if(count > maxCount){
                ansK = k;
                maxCount = count;
            }
        }
        System.out.print(ansK+" "+maxCount);
    }

    //K 초과인 칸만 탐색
    public static void bfs(int sx, int sy, boolean[][] visited, int k){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                if(grid[nx][ny] <= k) continue;
                q.offer(new int[]{nx,ny});
            }
        }
    }

}