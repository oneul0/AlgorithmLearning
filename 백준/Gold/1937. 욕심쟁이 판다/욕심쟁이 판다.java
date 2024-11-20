import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp, bam, d = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    static int N, max = 0;;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N]; bam = new int[N][N];

        for(int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0; j<N; j++){
                bam[i][j] = Integer.parseInt(s[j]);
            }
        }


        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                max = Math.max(dfs(i,j), max);
            }
        }

        bw.write(max+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int dfs(int x, int y){
        if(dp[x][y] != 0) return dp[x][y];

        int maxDepth = 1;
        for(int i = 0; i<4; i++){
            int nx = x+d[i][0];
            int ny = y+d[i][1];
            if(nx>=0 && nx<N && ny>=0 && ny<N && bam[nx][ny] > bam[x][y]){
                maxDepth = Math.max(maxDepth, dfs(nx, ny)+1);
            }
        }
        dp[x][y] = maxDepth;
        return maxDepth;
    }
}
