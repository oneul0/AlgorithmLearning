import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, S, ans = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int l = 1; l<=N; l++){
            dfs(0, 0, 0, l);
        }
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int len, int sum, int start, int maxLen){
        if(len == maxLen){
            if(sum == S) {
                ans++;
            }
            return;
        }
        //하나를 선택했을 때 나머지
        for(int i = start; i<N; i++){
            sum += arr[i];
            dfs(len+1, sum, i+1, maxLen);
            sum -= arr[i];
        }
    }
}