import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int[] lines = new int[40001], dp = new int[40001];
        for(int i = 1; i <=N; i++) {
            lines[i] = Integer.parseInt(s[i-1]);
        }

        int max = 0;
        for(int i = 1; i <= N; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(lines[i] > lines[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();

    }
}
