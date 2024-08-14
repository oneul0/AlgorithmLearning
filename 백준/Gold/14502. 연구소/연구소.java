
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static List<Pair> virus = new ArrayList<>();
    static int maxSafeBlockCnt = 0;
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    static int N,M;
    static int answer = 0;
    static ArrayList<Integer> results = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        //input
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        for(int i = 0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
                if(map[i][j] == 0) maxSafeBlockCnt++;
                else if(map[i][j] == 2) virus.add(new Pair(i, j));
            }
        }
        dfs(0,0,map);
        answer = results.stream().mapToInt(Integer::intValue).max().orElse(0);
        bw.write(Integer.toString(answer));
        bw.flush();
        br.close();
        bw.close();
    }


    //dfs
    //벽 조합 세우고
    static void dfs(int depth, int start, int[][] map){
        if(depth == 3){
            results.add(bfs(map));
            return;
        }

        for(int i = start; i<N*M; i++){
            int x = i/M;
            int y = i%M;
            if(map[x][y] == 0){
                map[x][y] = 1;
                dfs(depth+1,i+1, map);
                map[x][y] = 0;
            }
        }

    }

    //bfs
    //팀색
    static int bfs(int[][] map){
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for(Pair p : virus){
            q.offer(new Pair(p.X(), p.Y()));
        }

        while(!q.isEmpty()){
            Pair cur = q.remove();

            for(int i = 0; i<4; i++){
                int nx = cur.X() + dx[i];
                int ny = cur.Y() + dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<M&&!visited[nx][ny]&&map[nx][ny]==0){
                    q.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return  maxSafeBlockCnt-cnt-3;
    }


}


class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    int X(){
        return x;
    }
    int Y(){
        return y;
    }
}