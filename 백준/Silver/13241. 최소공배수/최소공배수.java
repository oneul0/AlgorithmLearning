import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        Long a = Long.parseLong(s[0]);
        Long b = Long.parseLong(s[1]);

        bw.write(Long.toString((a*b)/gcd(a, b)));
        br.close();
        bw.flush();
        bw.close();
    }
}
