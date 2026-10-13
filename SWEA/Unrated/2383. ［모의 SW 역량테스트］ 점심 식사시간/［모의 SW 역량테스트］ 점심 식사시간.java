
import java.io.*;
import java.util.*;

class Solution {

    static class Pos {
        int r, c, k;

        Pos(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

    // 한 계단에서 모든 사람이 내려가는 데 걸리는 시간
    static int calculate(int[] arrival, int count, int k) {
        if (count == 0) return 0;

        Arrays.sort(arrival, 0, count);

        int[] finish = new int[count];

        for (int i = 0; i < count; i++) {
            // 도착한 후 1분 뒤부터 계단 이용 가능
            int start = arrival[i] + 1;

            // 동시에 최대 3명만 이용 가능
            if (i >= 3) {
                start = Math.max(start, finish[i - 3]);
            }

            finish[i] = start + k;
        }

        return finish[count - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());

            List<Pos> people = new ArrayList<>();
            List<Pos> stairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st =
                    new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(st.nextToken());

                    if (value == 1) {
                        people.add(new Pos(i, j, 0));
                    } else if (value >= 2) {
                        stairs.add(new Pos(i, j, value));
                    }
                }
            }

            int p = people.size();

            // 사람별 각 계단까지 이동 거리
            int[][] dist = new int[p][2];

            for (int i = 0; i < p; i++) {
                Pos person = people.get(i);

                for (int j = 0; j < 2; j++) {
                    Pos stair = stairs.get(j);

                    dist[i][j] =
                        Math.abs(person.r - stair.r)
                        + Math.abs(person.c - stair.c);
                }
            }

            int answer = Integer.MAX_VALUE;

            int[] arrival0 = new int[p];
            int[] arrival1 = new int[p];

            // 모든 사람의 계단 배정 경우 탐색
            for (int mask = 0; mask < (1 << p); mask++) {
                int count0 = 0;
                int count1 = 0;

                for (int i = 0; i < p; i++) {
                    if ((mask & (1 << i)) == 0) {
                        arrival0[count0++] = dist[i][0];
                    } else {
                        arrival1[count1++] = dist[i][1];
                    }
                }

                int time0 = calculate(
                    arrival0, count0, stairs.get(0).k
                );

                int time1 = calculate(
                    arrival1, count1, stairs.get(1).k
                );

                // 모든 사람이 내려가야 완료
                int total = Math.max(time0, time1);

                answer = Math.min(answer, total);
            }

            sb.append("#").append(tc)
              .append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
