import java.util.*;
public class Main {
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || ny<0||nx>=n || ny>=m ||visited[nx][ny]) continue;
                if(grid[nx][ny] == 0) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        System.out.print(visited[n-1][m-1] ? 1 : 0);
    }
}