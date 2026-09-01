import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int test_case = 1; test_case <= 10; test_case++) {
            String tc = br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int val = 1;
            while (true) {
                int cur = q.poll() - val;
                val++;
                if (val > 5) val = 1;

                if (cur <= 0) {
                    q.offer(0);
                    break;
                }
                q.offer(cur);
            }

            bw.write("#" + tc + " ");
            while (!q.isEmpty()) {
                bw.write(q.poll() + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}