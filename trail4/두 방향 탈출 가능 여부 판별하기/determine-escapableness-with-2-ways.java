import java.util.*;
public class Main {
    static int n, m;
    static int[] dx=  {1,0}, dy = {0,1};
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        System.out.print(solve());
    }
    public static int solve() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == n - 1 && y == m - 1) {
                return 1;
            }

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (grid[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return 0;
    }
}