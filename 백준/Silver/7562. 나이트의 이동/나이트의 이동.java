import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-2, -1, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-1, -2, 1, 2, -2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tci = 0; tci < tc; tci++) {
            int l = Integer.parseInt(br.readLine());
            String[] from = br.readLine().split(" ");
            int sx = Integer.parseInt(from[0]);
            int sy = Integer.parseInt(from[1]);

            String[] to = br.readLine().split(" ");
            int tox = Integer.parseInt(to[0]);
            int toy = Integer.parseInt(to[1]);

            Queue<Pair> q = new LinkedList<>();
            boolean[][] chk = new boolean[l][l];
            int min = Integer.MAX_VALUE;
            q.add(new Pair(sx, sy, 0));
            while (!q.isEmpty()) {
                Pair cur = q.poll();
                if(cur.x == tox && cur.y == toy) {
                    min = Math.min(min, cur.dist);
                    break;
                }
                for(int i = 0; i < 8; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx>=0 && nx<l && ny>=0 && ny<l && !chk[nx][ny]) {

                        chk[nx][ny] = true;
                        q.add(new Pair(nx, ny, cur.dist + 1));
                    }
                }
            }
            sb.append(min).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}


class Pair{
    int x, y, dist;
    Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}