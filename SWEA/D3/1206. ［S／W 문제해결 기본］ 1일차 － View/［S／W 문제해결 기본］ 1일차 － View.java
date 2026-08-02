import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			bw.write("#"+ test_case +" "+ solve(N, arr) +"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	public static int solve(int N, int[] arr){
		int result = 0;
		for(int i = 2; i<N-2; i++){
			int maxH = Math.max(Math.max(arr[i-2], arr[i-1]), Math.max(arr[i+2], arr[i+1]));
			if(arr[i] > maxH){
				result += arr[i] - maxH;
			}
		}
		return result;
	}
}