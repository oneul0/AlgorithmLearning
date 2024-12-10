import java.util.*;

class Solution {
    int[][] map, rectangle;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        visited = new boolean[102][102];
        this.rectangle = rectangle;

        for (int[] rec : rectangle) {
            int xmin = rec[0] * 2;
            int ymin = rec[1] * 2;
            int xmax = rec[2] * 2;
            int ymax = rec[3] * 2;

            for (int x = xmin; x <= xmax; x++) {
                for (int y = ymin; y <= ymax; y++) {
                    if (x == xmin || x == xmax || y == ymin || y == ymax) {
                        map[x][y] = -1;
                    } else {
                        map[x][y] = 0;
                    }
                }
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        int ix = itemX * 2;
        int iy = itemY * 2;

        q.offer(new Pair(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;

        while (!q.isEmpty()) {
            Pair cur = q.remove();
            int cx = cur.x;
            int cy = cur.y;

            if (cx == ix && cy == iy) {
                answer = cur.dist / 2;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (map[nx][ny] == -1 && isIn(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx, ny, cur.dist + 1));
                }
            }
        }

        return answer;
    }

    boolean isIn(int nx, int ny) {
        for (int[] rec : rectangle) {
            int xmin = rec[0] * 2;
            int ymin = rec[1] * 2;
            int xmax = rec[2] * 2;
            int ymax = rec[3] * 2;

            if (nx > xmin && nx < xmax && ny > ymin && ny < ymax) return false;
            if ((nx == xmin || nx == xmax) && (ny >= ymin && ny <= ymax)) return true;
            if ((ny == ymin || ny == ymax) && (nx >= xmin && nx <= xmax)) return true;
        }
        return false;
    }
}

class Pair {
    int x, y, dist;

    Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
