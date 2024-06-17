import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int ab = 0, ba = 0, cnt = 0;
        HashSet<Integer> a = new HashSet<>();

        String[] k = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            a.add(Integer.parseInt(k[i]));
        }
        String[] t = br.readLine().split(" ");
        for(int i = 0; i<m; i++){
            if(a.contains(Integer.parseInt(t[i]))){
                cnt++;
            }
        }
        int ans = (k.length + t.length) - 2*cnt;

        bw.write(Integer.toString(ans));

        br.close();
        bw.flush();
        bw.close();
    }
}
