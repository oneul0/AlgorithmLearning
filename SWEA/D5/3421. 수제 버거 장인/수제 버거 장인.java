import java.util.*;
import java.io.*;

class Solution
{
    static int N, answer;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            boolean[][] canNot = new boolean[N+1][N+1];
            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                canNot[a][b] = true;
                canNot[b][a] = true;
            }
            comb(1, 1, canNot);
            bw.write("#"+test_case + " " + ++answer+"\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}
    
    public static void comb(int start, int mask, boolean[][] canNot){
        for(int i = start; i<=N; i++){
            if((mask & (1<<i)) != 0) continue;
            boolean flag = false;
            for(int j = 1; j<=N; j++){
                if(i==j) continue;
                if((mask & (1<<j)) != 0 && canNot[j][i]) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            mask |= (1<<i);
            answer++;
            comb(i+1, mask, canNot);
            mask &= ~(1<<i);
        }
    }
}