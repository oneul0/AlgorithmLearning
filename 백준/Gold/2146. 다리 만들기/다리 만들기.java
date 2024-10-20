import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int N, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        //입력
        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int gn = 2;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    makeNumber(i, j, gn);
                    gn++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 0){
                    cntBridge(i, j);
                }
            }
        }

        bw.write(min + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static void makeNumber(int sx, int sy, int groupNum){
        boolean[][] chk = new boolean[N][N];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy));
        chk[sx][sy] = true;
        map[sx][sy] = groupNum;
        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int i = 0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N || chk[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new Pair(nx, ny));
                chk[nx][ny] = true;
                map[nx][ny] = groupNum;
            }
        }
    }

    static void cntBridge(int sx, int sy){
        boolean[][] chk = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        chk[sx][sy] = true;

        while(!q.isEmpty()){
            int[] p = q.poll();

            if(p[2] >= min) continue;

            for(int i = 0; i<4; i++){
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N || chk[nx][ny]) continue;

                if(map[nx][ny] == 0){
                    q.offer(new int[]{nx, ny, p[2]+1});
                    chk[nx][ny] = true;
                }
                else if(map[nx][ny] != map[sx][sy]){
                    min = Math.min(min, p[2]);
                }
            }
        }
    }
}

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}