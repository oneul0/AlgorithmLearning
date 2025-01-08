import java.util.*;
import java.io.*;
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String args[]) throws Exception {

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[][] cheese = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] in = br.readLine().split(" ");
                for(int j = 0; j < in.length; j++){
                    cheese[i][j] = Integer.parseInt(in[j]);
                }
            }

            bw.write("#"+test_case+" "+simulation(cheese, N)+"\n");
            bw.flush();

        }
        bw.close();
        br.close();
    }

    static int simulation(int[][] cheese, final int N){
        int ans = 0;
        for(int i = 0; i <= 100; i++){
            ans = Math.max(ans, chuncks(cheese, i, N));
        }
        return ans;
    }

    static int chuncks(int[][] cheese, int day, final int N){
        boolean[][] chk = new boolean[cheese.length][cheese[0].length];
        int cnt = 0;
        for(int i = 0; i<cheese.length; i++){
            for(int j = 0; j<cheese[0].length; j++){
                if(cheese[i][j] > day && !chk[i][j]){
                    bfs(i,j,cheese,chk, day, N);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(int sx, int sy, int[][] cheese, boolean[][] chk, int day, final int N){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx,sy});

        chk[sx][sy] = true;

        while(!q.isEmpty()){
            int[] cur = q.remove();

            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||nx>=N|| ny<0||ny>=N || chk[nx][ny]) continue;
                if(cheese[nx][ny] <= day) {
                    chk[nx][ny] = true;
                    continue;
                }
                chk[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }
    }
}