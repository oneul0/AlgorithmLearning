import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static boolean[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }

        bw.write(Integer.toString(solution(N, M)));
        bw.flush();
        br.close();
        bw.close();
    }

    static int solution(int n, int m) {
        boolean[][][] chk = new boolean[n][m][2]; 
        Queue<int[]> q = new ArrayDeque<>();
        chk[0][0][0] = true;
        q.offer(new int[]{0, 0, 0, 1}); 

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];
            int dist = cur[3];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!map[nx][ny] && !chk[nx][ny][broken]) {
                        chk[nx][ny][broken] = true;
                        q.offer(new int[]{nx, ny, broken, dist + 1});
                    }

                    if (map[nx][ny] && broken == 0 && !chk[nx][ny][1]) {
                        chk[nx][ny][1] = true;
                        q.offer(new int[]{nx, ny, 1, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}
