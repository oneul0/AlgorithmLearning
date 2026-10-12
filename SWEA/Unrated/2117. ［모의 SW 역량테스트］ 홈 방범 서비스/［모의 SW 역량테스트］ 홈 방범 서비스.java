
import java.util.*;
import java.io.*;

class Solution {
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            // 모든 좌표를 서비스 중심으로 설정
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(
                        answer, count(i, j, n, m));
                }
            }

            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int count(int sx, int sy, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        // 거리별 집의 개수
        int[] houseCount = new int[2 * n - 1];

        q.offer(new int[] {sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (arr[x][y] == 1) {
                houseCount[dist]++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 ||
                    nx >= n || ny >= n ||
                    visited[nx][ny]) continue;

                q.offer(new int[] {nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }

        int max = 0;
        int houses = 0;

        // K별 서비스 가능한 집의 누적 개수
        for (int k = 1; k <= 2 * n - 1; k++) {
            houses += houseCount[k - 1];

            int fee = k * k + (k - 1) * (k - 1);

            // 손해를 보지 않는 경우
            if (houses * m >= fee) {
                max = Math.max(max, houses);
            }
        }

        return max;
    }
}
