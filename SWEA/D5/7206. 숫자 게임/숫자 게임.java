import java.util.*;
import java.io.*;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] memo;
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			memo = new int[100_000];
			Arrays.fill(memo, -1);
			bw.write("#"+test_case+" "+dfs(br.readLine())+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	public static int dfs(String val)throws Exception{
		int num = Integer.parseInt(val);
		if(val.length()<2) return 0;
		if(memo[num] != -1) return memo[num];

		int n = val.length();
		int result = 0;
		for(int mask = 1; mask < (1<<(n-1)); mask++){
			int product = 1;
			int start = 0;
			for(int i = 0; i<n-1;i++){
				//visited
				if((mask & (1<<i)) != 0){
					product *= Integer.parseInt(val.substring(start, i+1));
					start = i+1;
				}
			}

			product *= Integer.parseInt(val.substring(start));

			result  = Math.max(result, 1+dfs(String.valueOf(product)));
		}
		return memo[num] = result;
	}
}