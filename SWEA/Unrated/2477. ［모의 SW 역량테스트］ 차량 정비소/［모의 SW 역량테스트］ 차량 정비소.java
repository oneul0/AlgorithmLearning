import java.io.*;
import java.util.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static class Customer {
        int id, arrival, receptionDesk, receptionEnd;

        Customer(int id, int arrival) {
            this.id = id;
            this.arrival = arrival;
        }
    }

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        StringBuilder result = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = nextInt();
            int M = nextInt();
            int K = nextInt();
            int A = nextInt();
            int B = nextInt();

            int[] receptionTime = new int[N];
            int[] repairTime = new int[M];
            for (int i = 0; i < N; i++) receptionTime[i] = nextInt();
            for (int i = 0; i < M; i++) repairTime[i] = nextInt();

            Customer[] customers = new Customer[K];
            for (int i = 0; i < K; i++) {
                customers[i] = new Customer(i + 1, nextInt());
            }

            // 고객 번호 순서대로 접수 창구를 배정한다.
            int[] receptionFree = new int[N];
            for (Customer c : customers) {
                int chosen = 0;
                int start = Math.max(c.arrival, receptionFree[0]);

                for (int desk = 1; desk < N; desk++) {
                    int candidate = Math.max(c.arrival, receptionFree[desk]);
                    if (candidate < start) {
                        start = candidate;
                        chosen = desk;
                    }
                }

                c.receptionDesk = chosen + 1;
                c.receptionEnd = start + receptionTime[chosen];
                receptionFree[chosen] = c.receptionEnd;
            }

            // 정비 대기 순서: 접수 종료 시각, 접수 창구 번호.
            Arrays.sort(customers,
                Comparator.comparingInt((Customer c) -> c.receptionEnd)
                          .thenComparingInt(c -> c.receptionDesk));

            int[] repairFree = new int[M];
            int answer = 0;
            for (Customer c : customers) {
                int chosen = 0;
                int start = Math.max(c.receptionEnd, repairFree[0]);

                for (int desk = 1; desk < M; desk++) {
                    int candidate = Math.max(c.receptionEnd, repairFree[desk]);
                    if (candidate < start) {
                        start = candidate;
                        chosen = desk;
                    }
                }

                repairFree[chosen] = start + repairTime[chosen];
                if (c.receptionDesk == A && chosen + 1 == B) {
                    answer += c.id;
                }
            }

            result.append('#').append(tc).append(' ')
                  .append(answer == 0 ? -1 : answer).append('\n');
        }
        System.out.print(result);
    }
}
