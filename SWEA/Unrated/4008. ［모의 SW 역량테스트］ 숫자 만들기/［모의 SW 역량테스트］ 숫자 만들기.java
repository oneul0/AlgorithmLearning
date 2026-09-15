
import java.util.*;
import java.io.*;

class Solution
{
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int minVal, maxVal;
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			minVal = Integer.MAX_VALUE;
			maxVal = Integer.MIN_VALUE;
			int N = Integer.parseInt(br.readLine());
			int[] ops = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<4; i++) {
				ops[i] = Integer.parseInt(st.nextToken());
			}
			int[] nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i= 0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			permute(nums[0], ops, nums, 1);
			
			bw.write("#"+test_case+" "+(maxVal-minVal) +"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static void permute(int sum, int[] ops, int[] nums, int idx) {
		if(ops[0]+ops[1]+ops[2]+ops[3]==0) {
			minVal = Math.min(minVal, sum);
			maxVal = Math.max(maxVal, sum);
			return;
		}
		
		if(ops[0] > 0) {
			ops[0]--;
			permute(sum+nums[idx], ops, nums, idx+1);
			ops[0]++;
		}
		if(ops[1] > 0) {
			ops[1]--;
			permute(sum-nums[idx], ops, nums, idx+1);
			ops[1]++;
		}
		if(ops[2] > 0) {
			ops[2]--;
			permute(sum*nums[idx], ops, nums, idx+1);
			ops[2]++;
		}
		if(ops[3] > 0) {
			ops[3]--;
			permute(sum/nums[idx], ops, nums, idx+1);
			ops[3]++;
		}
	}
}