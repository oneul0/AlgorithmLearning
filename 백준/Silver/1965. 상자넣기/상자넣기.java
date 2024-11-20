import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n], dp = new int[n];
        for(int i = 0; i<s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i<n; i++){
            //각 경우에서 시작할 때 경우의 수는 1
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                //이전 수 보다 지금의 수가 작을 때
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int d : dp){
            max = Math.max(max, d);
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
