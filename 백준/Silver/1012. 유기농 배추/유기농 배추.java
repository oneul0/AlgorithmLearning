import java.io.*;
import java.text.DecimalFormat;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Pair{
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }

        public Integer getKey(){
            return key;
        }
        public Integer getValue(){
            return value;
        }

    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            boolean[][] map = new boolean[m][n];
            for(int i = 0; i < m; i++) {
                Arrays.fill(map[i], true);
            }

            for(int i = 0; i<k; i++){
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                map[x][y] = false; //방문 안 한데는 false;
            }
            //bfs
            int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            Queue<Pair> q = new LinkedList<>();

            int cnt = 0;
            for(int sx = 0; sx < m; sx++) {
                for(int sy = 0; sy < n; sy++) {
                    if(map[sx][sy]) { continue; }
                    q.add(new Pair(sx, sy));
                    map[sx][sy] = true;
                    while(!q.isEmpty()){
                        Pair cp = q.poll();
                        int cx = cp.getKey();
                        int cy = cp.getValue();

                        for(int i = 0; i < dir.length; i++){
                            int nx = cx+dir[i][0];
                            int ny = cy+dir[i][1];

                            if(nx>=0 && ny>=0 && nx<m && ny<n && !map[nx][ny]){
                                q.add(new Pair(nx,ny));
                                map[nx][ny] = true;
                            }
                        }
                    }
                    cnt++;
                }
            }
            bw.write(cnt+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}