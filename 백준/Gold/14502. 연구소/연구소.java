import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[][] lab;
    static int N, M;

    static ArrayList<Pair> virus = new ArrayList<>();
    static ArrayList<Pair> walls = new ArrayList<>();
    static int maxSafeTileCount = 0;
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        lab = new int[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(input[j]);
                if (lab[i][j] == 0) maxSafeTileCount++;
                else if (lab[i][j] == 2) virus.add(new Pair(i, j));
            }
        }


        // 벽을 세우는 조합 생성
        combine(0, deepCopy(lab));

        // 안전 영역의 최대
        int answer = results.stream().mapToInt(Integer::intValue).max().orElse(0);
        bw.write(String.valueOf(answer));
        bw.flush();
    }
    static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    // 벽을 세우는 조합 생성
    static void combine(int depth, int[][] lab) {
        if (depth == 3) {
            // 벽을 세운 후 바이러스 퍼뜨리기
            results.add(bfs(lab));
            return;
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (lab[x][y] == 0) {
                    lab[x][y] = 1; // 벽 세우기
                    combine(depth + 1, lab);
                    lab[x][y] = 0; // 상태 복원
                }
            }
        }
    }

    // 바이러스를 퍼뜨리기
    static int bfs(int[][] lab) {
        int cnt = 0;
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        // 초기 바이러스 위치 큐에 추가
        for (Pair v : virus) {
            q.add(new Pair(v.getX(), v.getY()));
            visited[v.getX()][v.getY()] = true;
        }

        while (!q.isEmpty()) {
            Pair cur = q.remove();
            int x = cur.getX();
            int y = cur.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && lab[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                    cnt++; // 바이러스 count
                }
            }
        }
        cnt += 3;
        return maxSafeTileCount-cnt; // 전체 안전지대에서 바이러스 퍼진 곳과 벽 세운 곳 뺀 값 반환
    }
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
