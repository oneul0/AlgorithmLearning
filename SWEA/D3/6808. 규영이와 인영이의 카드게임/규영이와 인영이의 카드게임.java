import java.util.*;
import java.io.*;

class Solution
{
    static int winCnt, loseCnt;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            winCnt = 0;
            loseCnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
            int mask =0;
            int[] arr = new int[9];
            for(int i = 0; i<9; i++){
                int cur = Integer.parseInt(st.nextToken());
                mask |= (1<<cur);
                arr[i] = cur;
            }
            comb(0, 0, 0, mask, arr);
            bw.write("#"+test_case+" "+winCnt+" " +loseCnt);
            bw.newLine();
		}
        bw.flush();
        br.close();
        bw.close();
	}
    
    public static void comb(int depth, int sumA, int sumB, int chk, int[] arr){
        if(depth == 9){
            if(sumA > sumB) winCnt++;
            else if(sumA < sumB) loseCnt++;
            return ;
        }
        
        for(int i = 1; i<=18; i++){
            if((chk & (1<<i)) != 0) continue;
            chk |= (1<<i);
            if(i < arr[depth]) comb(depth+1, sumA+i+arr[depth], sumB, chk, arr);
            else if(i>arr[depth]) comb(depth+1, sumA, sumB+i+arr[depth], chk, arr);
            chk &= ~(1 << i); 
        }
    }
}