import java.util.Scanner;

public class Main {
    static int n;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static int[][] grid;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int count = 0;
        int maxArea = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j]){
                    int area = dfs(i, j);
                    if(area >= 4) count++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.print(count +" "+maxArea);
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
        int area = 1;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny<0 || ny>=n || nx>=n || visited[nx][ny]) continue;
            if(grid[x][y] != grid[nx][ny]) continue;
            
            area += dfs(nx, ny);
        }
        return area;
    }
}