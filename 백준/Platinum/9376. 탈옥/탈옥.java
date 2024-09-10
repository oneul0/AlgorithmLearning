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
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);

            // 맵의 크기를 가로, 세로 2씩 늘려 빈 공간을 만들어준다.
            char[][] prison = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(prison[i], '.'); // 빈 공간으로 채우기
            }

            // 죄수들의 위치를 담을 ArrayList
            ArrayList<Cur> prisoners = new ArrayList<>();

            // 맵의 원래 크기부터 탐색
            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    prison[i][j] = line.charAt(j - 1);
                    //만약 죄수이면
                    if (prison[i][j] == '$') {
                        prisoners.add(new Cur(i, j, 0)); // 죄수의 위치 기록
                    }
                }
            }



            // 죄수1로부터 죄수2까지의 최단 거리와 그 반대의 거리
            int[][] distFromPrisoner1 = dijkstra(h, w, prison, prisoners.get(0));
            int[][] distFromPrisoner2 = dijkstra(h, w, prison, prisoners.get(1));
            // 감옥의 바깥으로부터 감옥 내부의 각 지점까지의 거리를 구하기 위한 탐색
            int[][] distFromOutside = dijkstra(h, w, prison, new Cur(0, 0, 0));

            // 세 지점의 합이 가장 작은 지점에서의 합을 찾는다.
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <= h + 1; i++) {
                for (int j = 0; j <= w + 1; j++) {
                    if (prison[i][j] == '*') continue; // 벽일 경우 pass

                    int sum = distFromPrisoner1[i][j] + distFromPrisoner2[i][j] + distFromOutside[i][j];

                    // 다익스트라 탐색은 총 3번 이루어지므로 각 지점에서의 가중치(문)를 더한 경우는 -2를 해야 정상 값이 나오게 된다.
                    //(중복을 제거할 수 있게 된다.)
                    if (prison[i][j] == '#') sum -= 2;

                    minCost = Math.min(minCost, sum);
                }
            }

            bw.write(minCost + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int[][] dijkstra(int h, int w, char[][] prison, Cur start) {
        int[][] dist = new int[h + 2][w + 2];
        for (int i = 0; i < h + 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Cur> pq = new PriorityQueue<>();
        pq.offer(start);
        dist[start.x][start.y] = 0;

        while (!pq.isEmpty()) {
            Cur cur = pq.poll();
            if (cur.cost > dist[cur.x][cur.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx <= h + 1 && ny >= 0 && ny <= w + 1) {
                    if (prison[nx][ny] == '*') continue; // 벽일 경우 pass

                    int nextCost = cur.cost;
                    if (prison[nx][ny] == '#') nextCost++; // 문을 만나면 +1

                    if (dist[nx][ny] > nextCost) {
                        dist[nx][ny] = nextCost;
                        pq.offer(new Cur(nx, ny, nextCost));
                    }
                }
            }
        }
        return dist;
    }
}

class Cur implements Comparable<Cur> {
    int x, y, cost;

    public Cur(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cur o) {
        return Integer.compare(this.cost, o.cost);
    }
}
