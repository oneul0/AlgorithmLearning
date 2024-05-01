import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String s="";
         num /= 4;
         for(int i = 0; i < num; i++){
             s+="long ";
         }
        s+="int";
         bw.write(s);
        br.close();
        bw.flush();
        bw.close();
    }
}