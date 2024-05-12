import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n+1];
        isPrime[0] = isPrime[1] = true;
        //에라토스테네스의 체
        for(int i=2; i*i<=n; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<=n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        int total = 0, minNum = 0;
        for(int i = m; i <= n; i++) {
            if(!isPrime[i]){
                total += i;
                if(minNum == 0){
                    minNum = i;
                }
            }
        }
        if(minNum == 0){
            bw.write("-1");
        }
        else{
            bw.write(total + "\n"+minNum);    
        }
        

        br.close();
        bw.flush();
        bw.close();
    }
}