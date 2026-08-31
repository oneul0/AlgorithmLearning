import java.util.*;
import java.io.*;
import java.math.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger bi = new BigInteger(st.nextToken());
			System.out.println("#"+test_case+" "+bi.add(new BigInteger(st.nextToken())));
		}
	}
}