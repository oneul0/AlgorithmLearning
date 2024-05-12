import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            StringBuilder sb = new StringBuilder();
            int total = 0;
            sb.append(n+" = ");
            for(int i = 1; i < n; i++){
                if(n % i == 0){
                    total += i;
                    sb.append(i+" + ");
                }
            }

            if(total == n){
                sb.delete(sb.length()-2, sb.length());
                bw.write(sb.toString() + "\n");
            }
            else{
                bw.write(n+ " is NOT perfect." + "\n");
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }
}