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
			st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
         	Arrays.sort(arr);
            int l = 0;
            int r = arr.length-1;
            int maxVal = 0;
            while(l<r){
                int sum = arr[l] + arr[r];
                if(sum<=M){
                    maxVal = Math.max(maxVal, sum);
                    l++;
                }
                else {
                    r--;
                }
            }
            bw.write("#"+test_case+" " + (maxVal == 0 ? -1 : maxVal));
            bw.newLine();
		}
        bw.flush();
        br.close();
        bw.close();
	}
}