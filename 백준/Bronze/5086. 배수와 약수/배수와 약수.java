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
        while(true){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) {
                break;
            }
            String ans = "neither";
            //첫번째 수가 두번째 수보다 작으면(약수 혹은 둘 다 아님)
            if(n<=m){
                if(m%n == 0){
                    ans = "factor";
                }
            }
            //첫번째 수가 두번째 수보다 크면(배수 혹은 둘 다 아님)
            else{
                if(n%m == 0){
                    ans = "multiple";
                }
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}