import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1][2];
        //길이가 1인 이친수
        //1
        dp[1][1] = 1;
        //길이가 2인 이친수
        //10
        //길이가 3인 이친수
        //100 101
        //길이가 4인 이친수
        //0 : 1010 1000
        //1 : 1001
        //길이가 5인 이친수
        //0 : 10010  10100 10000
        //1 : 10101 10001
        //길이가 6인 이친수
        // 0 : 100100 101000 100000 101010 100010
        // 1 : 100101 101001 100001
        //점화식
        // 길이가 n인 이친수
        // 길이가 n-1인 이친수 중 0으로 끝나면 0, 1 이므로 +2
        // 길이가 n-1인 이친수 중 1로 끝나면 1 이므로 +1
        //길이가 n일 때 1로 끝나는 것/ 0으로 끝나는 것의 개수
        //
        for(int i = 2; i<=N; i++){
            dp[i][0] = dp[i-1][1]+dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }


        bw.write((dp[N][0]+dp[N][1])+"");
        bw.flush();
        br.close();
        bw.close();
    }
}

