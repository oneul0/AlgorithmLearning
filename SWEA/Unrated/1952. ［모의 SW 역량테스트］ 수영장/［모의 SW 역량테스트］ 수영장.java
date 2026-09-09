import java.util.*;
import java.io.*;

class Solution
{
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
            int[] fee = new int[4]; //1d 1m 3m 1y
            for(int i = 0; i<4; i++){
                fee[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[12];
            for(int i = 0; i<12; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[13];

            for (int i = 11; i >= 0; i--) {
                int daily = arr[i] * fee[0] + dp[i + 1];
                int oneMonth = fee[1] + dp[i + 1];

                int threeMonth = fee[2];
                if (i + 3 < 12) {
                    threeMonth += dp[i + 3];
                }

                dp[i] = Math.min(daily, Math.min(oneMonth, threeMonth));
            }
            int answer = Math.min(dp[0], fee[3]);
            bw.write(answer+"\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}
}

/*
각각의 달에 이용할 날은
일일권으로 끊냐 1달, 3달 이용권으로 끊냐 차이

*/