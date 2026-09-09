import java.util.*;
import java.io.*;

class Solution
{
    static int N, B;
    static int minDiff;

    static int[] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            minDiff = 987654321;
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            bw.write("#"+test_case+" "+minDiff+"\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}
    public static void dfs(int idx, int sum){
        if(sum >= B) {
            minDiff = Math.min(minDiff, Math.abs(B-sum));
            return;
        }
        for(int i = idx; i<N; i++){
            dfs(i+1, sum+arr[i]);
        }
    }
}