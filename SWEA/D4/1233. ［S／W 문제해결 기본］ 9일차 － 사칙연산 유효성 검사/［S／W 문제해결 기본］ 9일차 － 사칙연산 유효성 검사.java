import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            bw.write("#"+test_case+" ");
            
            StringTokenizer st;
			int N = Integer.parseInt(br.readLine());
            boolean valid = true;
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int cur = Integer.parseInt(st.nextToken());
                boolean isNumber = st.nextToken().chars().allMatch(Character::isDigit);
                boolean hasChild = st.hasMoreTokens();
                
                if(isNumber && hasChild || !isNumber && !hasChild) {
                    valid = false;
                }
            }
            bw.write(valid ? "1" : "0");
            bw.newLine();
            bw.flush();
		}
        
        br.close();
        bw.close();
	}
}