import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<m; j++){
                if(line[j].equals("1")){
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0, cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(visited[i][j]){
                    ans = Math.max(bfs(i, j), ans);
                    cnt++;
                }
            }
        }
        bw.write(cnt +"\n"+ ans);
        bw.flush();
        br.close();
        bw.close();
    }


    static int bfs(int sx, int sy){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = false;
        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&visited[nx][ny]){
                    visited[nx][ny] = false;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
