
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            boolean[][] canGo = new boolean[N+1][N+1];
            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                canGo[from][to] = true;
            }
            
            for(int k = 1; k<=N; k++){
                for(int from = 1; from <=N; from++){
                    for(int to = 1; to<=N; to++){
                        if(canGo[from][k] && canGo[k][to]){
                            canGo[from][to] = true;
                        }
                    }
                }
            }
            int answer = 0;
            for(int i = 1; i<=N; i++){
                int count  =0;
                for(int j = 1; j<=N; j++){
                    if(i == j) continue;
                    if(canGo[i][j] || canGo[j][i]) {
                        count++;
                    }

                }
                if(count == N-1){
                    answer++;
                }
            }
            
            bw.write("#"+test_case+" "+answer+"\n");

		}
        bw.flush();
        br.close();
        bw.close();
	}
}