import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Day> arr = new ArrayList<>();
    public static void main(String[] args) throws  Exception{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dp = new int[N+2];
        arr.add(new Day(0,0));

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i = N; i > 0; i--){
            if(i+arr.get(i).T > N+1) dp[i] = dp[i+1];
            else dp[i] = Math.max(dp[i+1], dp[i+arr.get(i).T]+arr.get(i).P);
        }
        bw.write(dp[1]+"");
        bw.flush();
        br.close();
        bw.close();
    }
    static class Day {
        int T, P;
        Day(int T, int P){
            this.T = T;
            this.P = P;
        }
    }
}
