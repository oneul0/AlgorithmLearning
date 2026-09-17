import java.util.*;
import java.io.*;

class Solution
{
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" ");
			long N = Long.parseLong(br.readLine());
            long answer = 0;

            while(N > 2) {
                long sqrt = (long) Math.sqrt(N);

                if(sqrt * sqrt == N) {
                    N = sqrt;
                    answer++;
                }
                else {
                    sqrt++;
                    answer += sqrt * sqrt - N + 1;
                    N = sqrt;
                }
            }
			bw.write(answer+"");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}