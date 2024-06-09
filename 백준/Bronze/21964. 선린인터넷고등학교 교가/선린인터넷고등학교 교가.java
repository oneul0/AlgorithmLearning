import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        private String x, y;

        Pair(String x, String y){
            this.x = x;
            this.y = y;
        }

        public String x(){
            return x;
        }

        public String y(){
            return y;
        }

        @Override
        public int compareTo(Pair o){
            return this.x.compareTo(o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = n-5;
        String[] s = br.readLine().split("");
        String tmp = "";
        for(int i = m; i<n; i++){
            tmp += s[i];
        }
        bw.write(tmp);
        br.close();
        bw.flush();
        bw.close();
    }
}
