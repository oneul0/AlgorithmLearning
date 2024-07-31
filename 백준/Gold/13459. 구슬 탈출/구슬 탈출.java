import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //✅ 입력 형식에 맞춰서 입력값을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());
        boolean[][] wall = new boolean[N][M];

        //✅ 빨간 구슬과 파란 구슬의 위치를 저장한다.
        Point red = null, blue = null, out = null;
        for(int x = 0; x < N; x++){
            char[] line = br.readLine().toCharArray();
            for(int y = 0; y<M; y++){
                if(line[y] == '#') wall[x][y] = true;
                else if(line[y] == 'R') red = new Point(x,y);
                else if(line[y] == 'B') blue = new Point(x,y);
                else if(line[y] == 'O') out = new Point(x,y);
            }
        }

        //✅ 두 구슬의 초기 위치를 시작으로 BFS 알고리즘을 수행한다.
        Queue<Entry> q = new ArrayDeque<>();
        Set<Entry> visited = new HashSet<>();
        q.add(new Entry(red, blue, 0));
        visited.add(q.peek());

        final int[] dx = {-1,0,1,0};
        final int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            Entry cur = q.remove();

            //✅ 움직임 횟수가 10을 초과하면 반복문을 종료한다.
            if(cur.distance == 10) continue;
            red = cur.red;
            blue = cur.blue;

            for(int d = 0; d<4; d++){
                //✅ 기울이는 방향에 따른 두 구슬의 다음 위치를 구한다.
                // 빨간공 움직이기
                Point nxtRed = new Point(red.x + dx[d], red.y + dy[d]);

                boolean isRedOut = false;
                // 움직일 수 없을 때까지 같은 방향으로 이동
                while(nxtRed.valid(wall)){
                    // out이면 탈출시키고 반복 종료
                    if(nxtRed.equals(out)){
                        nxtRed.x += dx[d];
                        nxtRed.y += dy[d];
                        isRedOut = true;
                        break;
                    }
                    nxtRed.x += dx[d];
                    nxtRed.y += dy[d];
                }
                // 유효하지 않은 위치 이동 취소
                nxtRed.x -= dx[d];
                nxtRed.y -= dy[d];

                // 파란공 움직이기
                Point nxtBlue = new Point(blue.x + dx[d], blue.y + dy[d]);
                boolean isBlueOut = false;
                while(nxtBlue.valid(wall)){
                    // 파란공이 나갔다면 나간 지점에서 반복 종료
                    if(nxtBlue.equals(out)){
                        nxtBlue.x += dx[d];
                        nxtBlue.y += dy[d];
                        isBlueOut = true;
                        break;
                    }

                    nxtBlue.x += dx[d];
                    nxtBlue.y += dy[d];
                }
                nxtBlue.x -= dx[d];
                nxtBlue.y -= dy[d];

                //✅ 두 구슬의 다음 위치가 동일할 때, 이동 횟수가 더 많은 구슬의 위치를 한 칸 뒤로 이동한다.
                //위치가 동일하다면 뒤에 있는 구슬이 더 많이 움직였으므로.
                if(nxtRed.equals(nxtBlue)){
                    if(red.getDistance(nxtRed) > blue.getDistance(nxtBlue)){
                        nxtRed.x -= dx[d];
                        nxtRed.y -= dy[d];
                    }else{
                        nxtBlue.x -= dx[d];
                        nxtBlue.y -= dy[d];
                    }
                }

                //✅ 파란 구슬의 다음 위치가 구멍이라면, 다른 방향으로 기울이기를 시도한다.
                //✅ 두 구슬의 다음 위치가 이미 방문했던 위치라면, 다른 방향으로 기울이기를 시도한다.
                Entry nxt = new Entry(nxtRed, nxtBlue, cur.distance+1);
                if(isRedOut && !isBlueOut){
                    //✅ 성공 여부에 따라서 1 또는 0을 출력한다.
                    System.out.println(1);
                    return;

                }else if(!isBlueOut && !visited.contains(nxt)){
                    //계속 탐색
                    q.add(nxt);
                    visited.add(nxt);
                }
            }
        }
        System.out.println(0);
        br.close();
    }

    static class Entry{
        Point red;
        Point blue;
        int distance;

        public Entry(Point red, Point blue, int distance){
            this.red = red;
            this.blue = blue;
            this.distance = distance;
        }

        //red blue 값 비교하는 equals 재정의
        @Override
        public boolean equals(Object o){
            if(o instanceof Entry){
                Entry e = (Entry) o;
                return red.equals(e.red) && blue.equals(e.blue);
            }
            return false;
        }
        //equals 재정의하려면 hashCode도 재정의 되어야 함.
        @Override
        public int hashCode(){
            return Objects.hash(red, blue);
        }

    }

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean valid(boolean[][] wall){
            return !wall[x][y];
        }

        //맨하탄 거리 구하기
        public int getDistance(Point o){
            return Math.abs(x - o.x) + Math.abs(y - o.y);
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof Point){
                Point p = (Point) o;
                return x == p.x && y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }

    }
}