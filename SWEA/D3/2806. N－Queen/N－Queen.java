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
			bw.write("#"+test_case+" ");
            int N = Integer.parseInt(br.readLine());
            if(N == 1) bw.write(1+"\n");
            else {
                bw.write(solve(0, 0, 0, 0, 0, N) + "\n");
            }
		}
        bw.flush();
        br.close();
        bw.close();
	}
    public static int solve(int row, int col, int rd, int ld, int cnt, int n){
        int result = 0;
        if(row == n) return 1;
        //result += solve(row+1, col, rd, ld, cnt, n);
        for(int c = 0; c<n; c++){
            int rdIdx = (row-c)+n;
            int ldIdx = (row+c);
            if(
                (col & (1<<c)) !=0 || 
                (rd & (1<<rdIdx)) !=0 || 
                (ld & (1<<ldIdx)) !=0
            ) continue;
            result += solve(row+1, (col | (1<<c)), (rd | (1<<rdIdx)), (ld | (1<<ldIdx)), cnt+1, n);
        }
        return result;
    }
}