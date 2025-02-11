import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 0;
        for(int i = 2; i<=N; i++){
            dp[i] = dp[i-1]+1;
            //연산 횟수가 더 작은 경우 횟수+1을 하여 다음 숫자로 넘어감
            if(i%3 == 0) dp[i] = Math.min(dp[i] , dp[i/3]+1);
            if(i%2==0) dp[i] = Math.min(dp[i] , dp[i/2]+1);
        }
        bw.write(dp[N]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
