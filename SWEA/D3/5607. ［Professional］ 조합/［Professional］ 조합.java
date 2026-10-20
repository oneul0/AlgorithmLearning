import java.util.*;
import java.io.*;

class Solution {

    static final long MOD = 1234567891;

    static long pow(long a, long b) {
        long result = 1;
        
        while (b > 0) {
            if (b % 2 == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b /= 2;
        }

        return result;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long a = 1;
            long b = 1;

            int count = R;

            while (count-- > 0) {
                a *= N--;
                a %= MOD;
            }

            for (int i = R; i > 1; i--) {
                b *= i;
                b %= MOD;
            }

            long result = a * pow(b, MOD - 2) % MOD;

            bw.write("#" + test_case + " " + result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}