import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            long n = Long.parseLong(br.readLine());
            while (!isPrime(n)) {
                n++;
            }
            bw.write(n + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
