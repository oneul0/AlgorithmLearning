import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static ArrayList<Pair> days = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        int[] DP = new int[20];
        for(int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            int p = Integer.parseInt(s[1]);
            days.add(new Pair(t, p));
        }


        for(int i = N; i>=1; i--){
            // dp 테이블 채우는 것의 일관성을 위해 상담을 하지 않을 때도 dp테이블을 채움
            // 다만, 상담을 하지 않으므로 dp[i] == dp[i+1]의 형태를 가짐
            if(i+days.get(i-1).t > N+1){
                DP[i] = DP[i+1];
            }
            else{
                //상담을 하게 되면 가장 p가 큰 값으로 채워야하므로 더한 값의 최대값을 저장
                DP[i] = Math.max(DP[i+1], DP[i+days.get(i-1).t]+days.get(i-1).p);
            }
        }
        bw.write(DP[1]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}


class Pair{
    int t,p;
    Pair(int t, int p){
        this.t = t;
        this.p = p;
    }
}