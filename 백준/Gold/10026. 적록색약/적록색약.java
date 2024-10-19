import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static char[][] pic;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

         pic = new char[N][N];

        //그림 입력 받기
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                pic[i][j] = s.charAt(j);
            }
        }
        bw.write(solution(false)+" "+solution(true));
        bw.flush();
        br.close();
        bw.close();
    }

    static int solution(boolean isBlind){
        boolean[][] chk = new boolean[N][N];
        int cnt = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!chk[i][j]){
                    cnt++;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i,j));

                    chk[i][j] = true;
                    char pixel = pic[i][j];


                    while(!q.isEmpty()){
                        Pair p = q.poll();

                        for(int d = 0; d<4; d++){
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N || chk[nx][ny]) continue;

                            if (isBlind) {
                                if ((pixel == 'R' || pixel == 'G') && (pic[nx][ny] == 'R' || pic[nx][ny] == 'G')) {
                                    chk[nx][ny] = true;
                                    q.add(new Pair(nx, ny));
                                } else if (pixel == 'B' && pic[nx][ny] == 'B') {
                                    chk[nx][ny] = true;
                                    q.add(new Pair(nx, ny));
                                }
                            } else if (pixel == pic[nx][ny]) {
                                chk[nx][ny] = true;
                                q.add(new Pair(nx, ny));
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}