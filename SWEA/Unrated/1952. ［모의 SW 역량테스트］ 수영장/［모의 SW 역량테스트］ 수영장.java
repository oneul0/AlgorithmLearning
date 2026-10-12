
import java.util.*;
import java.io.*;

class Solution
{
    static int[] fee, arr;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            bw.write("#"+test_case+" ");
			st = new StringTokenizer(br.readLine());

            fee = new int[4]; //1d 1m 3m 1y
            for(int i = 0; i<4; i++){
                fee[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            arr = new int[13];
            for(int i = 1; i<=12; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int minVal = Integer.MAX_VALUE;
            int[] dp = new int[13];
            for(int m = 1; m<=12; m++) {
            	int day = dp[m-1] + arr[m] * fee[0];
            	int month = dp[m-1] + fee[1];
            	dp[m] = Math.min(day, month);
            	if(m>=3) dp[m] = Math.min(dp[m], dp[m-3] + fee[2]);
            	else dp[m] = Math.min(dp[m], fee[2]);
            }
            int answer = Math.min(dp[12], fee[3]);
            bw.write(answer+"\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}
}