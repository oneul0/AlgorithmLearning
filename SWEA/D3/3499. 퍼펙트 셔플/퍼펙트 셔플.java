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
			int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            String[] arr = new String[n];
            for(int i = 0; i<n; i++){
                arr[i] = st.nextToken();
            }
            String[] answer = new String[n];
            int eidx = 0;
            int oidx = (n + 1) / 2;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    answer[i] = arr[eidx++];
                } else {
                    answer[i] = arr[oidx++];
                }
            }
            bw.write("#"+test_case+" ");
            for(String a : answer){
                bw.write(a+" ");
            }
            bw.newLine();
            bw.flush();
		}
        br.close();
        bw.close();
	}
}