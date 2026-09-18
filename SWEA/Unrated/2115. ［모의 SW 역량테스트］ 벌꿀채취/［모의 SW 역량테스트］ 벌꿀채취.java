import java.util.*;
import java.io.*;

class Solution
{
	static int N, M, C;
	static int[][] arr, profits;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			profits = new int[N][N];
			for(int i= 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				for(int j = 1; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<=N-M; j++) {
					profits[i][j] = comb(i, j, 0, 0, 0);
				}
			}
			int answer = comb2(0, 0, 0, 0, new boolean[N][N]);
			
			bw.write(answer+"");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static int comb2(int x, int y, int depth, int sum, boolean[][] visited) {
		if(depth == 2) {
			return sum;
		}
		int result = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<=N-M; j++) {
				boolean possible = true;

	            for(int k = 0; k < M; k++) {
	                if(visited[i][j+k]) {
	                    possible = false;
	                    break;
	                }
	            }

	            if(!possible) continue;

	            for(int k = 0; k<M; k++) {
	                visited[i][j+k] = true;
	            }

				result = Math.max(result, comb2(i, j, depth+1, sum+profits[i][j], visited));
				
				for(int k = 0; k<M; k++) {
	                visited[i][j+k] = false;
	            }
			}
		}
		return result;
	}
	public static int comb(int x, int y, int depth, int sum, int profit) {
		if(depth == M) {
			return profit;
		}
		
		int val = arr[x][y+depth];
		int maxProfit = comb(x, y, depth+1, sum, profit);
		if(sum + val <= C) {
			maxProfit = Math.max(maxProfit, comb(x, y, depth +1, sum+val, profit + val*val));
		}
		
		return maxProfit;
	}
	
}