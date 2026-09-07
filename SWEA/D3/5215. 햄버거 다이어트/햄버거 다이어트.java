import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[][] dp = new int[N+1][L+1];
            int[][] ing = new int[N+1][2];
            for(int i = 1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                ing[i] = new int[]{score, cal};
            }
			for(int i  = 1; i<=N; i++){
                for(int c = 0; c<=L; c++){
                    int score = ing[i][0];
                    int cal = ing[i][1];
                    if(cal > c) dp[i][c] = dp[i-1][c];
                    else dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-cal] + score);
                }
            }
            bw.write("#"+test_case+" " + dp[N][L]);
            bw.newLine();
		}
        br.close();
        bw.close();
	}
}