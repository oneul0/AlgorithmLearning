import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] dp = new int[11];
            dp[1] = 1; dp[2] = 2; dp[3] = 4;
            for(int j = 4; j<=num; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            bw.write(dp[num] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}