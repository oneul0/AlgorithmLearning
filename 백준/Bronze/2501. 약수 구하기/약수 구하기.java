import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0, ans = 0;
        for(int i = 1; i<=n; i++){
            if(n % i == 0){
                ans = i;
                cnt++;
                if(cnt == k){
                    break;
                }
            }
        }
        if(cnt == k){
            bw.write(Integer.toString(ans));
        }
        else{
            bw.write("0");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}