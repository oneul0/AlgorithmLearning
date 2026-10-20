
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long X = Long.parseLong(st.nextToken());
            long Y = Long.parseLong(st.nextToken());

            long p = Y;

            // X보다 큰 가장 작은 Y의 거듭제곱
            while (p <= X) {
                p *= Y;
            }

            // X의 배수 중 p 이상인 가장 작은 수
            long b = ((p + X - 1) / X) * X;

            long a = b * Y + X;

            sb.append(a).append(" ").append(b).append("\n");
        }

        System.out.print(sb);
    }
}
