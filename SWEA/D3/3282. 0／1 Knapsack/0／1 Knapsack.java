import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] dp = new int[N+1][K+1];
            int[] V = new int[N+1];
            int[] C = new int[N+1];
            
            for(int i = 1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=K; j++){
                    if(j<V[i]){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-V[i]]+C[i]);
                    }
                }
            }
            bw.write("#"+test_case+" "+dp[N][K]+"\n");
		}
        bw.flush();
        
	}
}