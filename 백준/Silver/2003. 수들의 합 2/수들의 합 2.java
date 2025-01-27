import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, ans = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
       arr = new int[N];
       s= br.readLine().split(" ");
       for(int i = 0; i<N; i++){
           arr[i] = Integer.parseInt(s[i]);
       }
       continuousSub();

       bw.write(ans+"");
       bw.flush();
       br.close();
       bw.close();
    }

    static void continuousSub(){
        for(int i = 0; i<N; i++){
            int sum = 0;
            for(int j = i; j<N; j++){
                sum+=arr[j];
                if(sum == M) ans++;
            }
        }
    }
}
//연속된 부분수열
