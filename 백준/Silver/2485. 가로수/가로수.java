import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) throws IOException {
        int total = 0,ctmp;
        int n = Integer.parseInt(br.readLine());
        Integer[] subs = new Integer[n];
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(i > 0){
                ctmp =arr[i] - arr[i-1];
                subs[i-1] = ctmp;
            }
        }

        int tmp = subs[0];
        for(int i = 1; i < n-1; i++) {
            tmp = gcd(tmp, subs[i]);
        }

        for(int i = 1; i < n; i++) {
            int t = arr[i]-arr[i-1];
            if(t == tmp){
                continue;
            }
            total += (t/tmp-1);
        }
        bw.write(Integer.toString(total));

        br.close();
        bw.flush();
        bw.close();
    }
}
