import java.util.*;

public class Main {
    static int n, result;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        
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
        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb.toString());

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