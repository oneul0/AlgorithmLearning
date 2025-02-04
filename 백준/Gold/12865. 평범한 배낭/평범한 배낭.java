import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];

        ArrayList<Pair> arr= new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i = 1; i<=N; i++){
            int w = arr.get(i-1).W;
            int v = arr.get(i-1).V;
            
            for(int j = 0; j<= K; j++){
                if(w>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], v+dp[i-1][j-w]);
            }
        }
        
        bw.write(dp[N][K]+"");
        bw.flush();
        bw.close();
        br.close();
        
    }
}

class Pair{
    int W, V;
    Pair(int W, int V){
        this.W = W;
        this.V = V;
    }
}