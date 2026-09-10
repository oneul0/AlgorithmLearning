import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] h = new int[N];
            for(int i = 0; i<N; i++){
                h[i] = sc.nextInt();
            }
            int answer = 0;

            for (int i = 1; i<N-1; i++) {
                //조건을 만족하는 봉우리 찾기
                if (h[i-1] < h[i] && h[i] > h[i+1]) {
                    int left = 0;
                    int right = 0;

                    // 왼쪽으로 얼마나 계속 증가해 왔는지
                    int p = i;
                    while (p > 0 && h[p-1] < h[p]) {
                        left++;
                        p--;
                    }

                    // 오른쪽으로 얼마나 계속 감소하는지
                    p = i;
                    while (p < N-1 && h[p] > h[p+1]) {
                        right++;
                        p++;
                    }

                    answer += left * right;
                }
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}