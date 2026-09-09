import java.util.*;
import java.io.*;

class Solution
{
    static int min;
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
            min = Integer.MAX_VALUE;
            fee = new int[4]; //1d 1m 3m 1y
            for(int i = 0; i<4; i++){
                fee[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            arr = new int[12];
            for(int i = 0; i<12; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
			backtrack(0, 0);
            int answer = Math.min(min, fee[3]);
            bw.write(answer+"\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}
    
public static void backtrack(int charge, int cur) {
        if (charge >= min)  return;

        if (cur >= 12) {
            min = Math.min(min, charge);
            return;
        }

        if (arr[cur] == 0) {
            backtrack(charge, cur + 1);
            return;
        }

        backtrack(charge + arr[cur] * fee[0], cur + 1);
        backtrack(charge + fee[1], cur + 1);
        backtrack(charge + fee[2], cur + 3);
    }
}