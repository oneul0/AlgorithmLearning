import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String str = solution();
            bw.write(str + '\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static String solution() throws IOException {

        String[] wh = br.readLine().split(" ");
        int w = Integer.parseInt(wh[0]);
        int h = Integer.parseInt(wh[1]);

        char[][] building = new char[h][w];
        Queue<Current> fireQueue = new ArrayDeque<>();
        Queue<Current> personQueue = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                building[i][j] = s.charAt(j);
                if (building[i][j] == '*') {
                    fireQueue.offer(new Current(i, j, 0));  // 불의 위치
                } else if (building[i][j] == '@') {
                    personQueue.offer(new Current(i, j, 0));  // 사람의 위치
                }
            }
        }

        boolean[][] visited = new boolean[h][w];
        boolean flag = false;
        int time = 0;

        // 불
        while (!personQueue.isEmpty()) {
            int fireSize = fireQueue.size();
            while (fireSize-- > 0) {
                Current fire = fireQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = fire.x + dx[i];
                    int ny = fire.y + dy[i];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && building[nx][ny] == '.') {
                        building[nx][ny] = '*';
                        fireQueue.offer(new Current(nx, ny, 0));
                    }
                }
            }

            // 상근
            int personSize = personQueue.size();
            while (personSize-- > 0) {
                Current person = personQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = person.x + dx[i];
                    int ny = person.y + dy[i];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        flag = true;
                        time = person.dist + 1;
                        break;
                    }

                    if (building[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        personQueue.offer(new Current(nx, ny, person.dist + 1));
                    }
                }

                if (flag) break;
            }

            if (flag) break;
        }

        return flag ? Integer.toString(time) : "IMPOSSIBLE";
    }
}

class Current {
    int x, y, dist;

    Current(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
