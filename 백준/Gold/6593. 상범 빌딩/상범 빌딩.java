import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1,1,0,0, 0,0};
    static int[] dy = {0,0,-1,1, 0,0};
    static int[] df = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        while (true) {
            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            bw.write(Solution(L, R, C));

        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String Solution(int L, int R, int C) throws IOException {
        boolean[][][] map = new boolean[R][C][L];
        Cur end= new Cur(0,0,0, 0);
        Queue<Cur> q = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String line = br.readLine();
                for (int k = 0; k < C; k++) {
                    if (line.charAt(k) == '.') continue;
                    if (line.charAt(k) == 'S') {
                        q.offer(new Cur(j, k, i, 0));
                        map[j][k][i] = true;
                    } else if (line.charAt(k) == '#') {
                        map[j][k][i] = true;
                    } else if (line.charAt(k) == 'E') {
                        end = new Cur(j, k, i, 0);
                    }
                }
            }
            br.readLine();
        }

        while(!q.isEmpty()) {
            Cur cur = q.poll();
            if(cur.equals(end)) return "Escaped in "+cur.time+" minute(s).\n";

            int cx = cur.x;
            int cy = cur.y;
            for(int i = 0; i<6; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nf = cur.floor + df[i];
                if(nx>=0&&ny>=0&&nx<R&&ny<C&&nf>=0&&nf<L&&!map[nx][ny][nf]){
                    map[nx][ny][nf] = true;
                    q.offer(new Cur(nx, ny, nf, cur.time+1));
                }
            }

        }

        return "Trapped!\n";
    }
}

class Cur {
    int x, y, floor, time;

    Cur(int x, int y, int floor, int time) {
        this.x = x;
        this.y = y;
        this.floor = floor;
        this.time = time;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cur)) return false;
        Cur other = (Cur) obj;
        return this.x == other.x && this.y == other.y && this.floor == other.floor;
    }
}