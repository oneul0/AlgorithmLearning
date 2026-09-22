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
                
        
        List<Integer> list = new ArrayList<>();
        visited = new boolean[n][n];
        for(int i =0 ; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    result = 0;
                    visited[i][j] = true;
                    dfs(i, j);
                    list.add(result);
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int i = 0; i<list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb.toString());

    }

    public static void dfs(int x, int y){
        result+=1;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
            if(visited[nx][ny] || grid[nx][ny] == 0) continue;
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}