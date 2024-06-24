import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int MAX = 1000001;
    static boolean[] isPrime = new boolean[MAX];

    static void eratos() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        eratos();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 2; i <= n / 2; i++) { // n/2까지 반복
                if (isPrime[i] && isPrime[n - i]) { // i와 n-i 둘 다 소수인지 확인
                    cnt++;
                }
            }
            bw.write(Integer.toString(cnt) + '\n');
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
