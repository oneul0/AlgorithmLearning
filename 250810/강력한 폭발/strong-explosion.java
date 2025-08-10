import java.util.*;

public class Main {
    static int result = 0, n;
    static int[][][] bomb = {
        { {-2, 0}, {-1, 0}, {1, 0}, {2, 0}, {0, 0} },
        { {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0} },
        { {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, 0} }
    };
    static ArrayList<int[]> bombPos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    bombPos.add(new int[]{i, j});
                }
            }
        }

        boolean[][] chk = new boolean[n][n];
        simulation(0, 0, chk);
        System.out.print(result);
        sc.close();
    }

    public static void simulation(int depth, int count, boolean[][] chk) {
        if (depth == bombPos.size()) {
            result = Math.max(result, count);
            return;
        }

        int cx = bombPos.get(depth)[0];
        int cy = bombPos.get(depth)[1];

        for (int i = 0; i < 3; i++) {
            boolean[][] nextChk = copyChk(chk);
            int newCount = count;

            // 폭발 범위
            for (int d = 0; d < 5; d++) {
                int nx = cx + bomb[i][d][0];
                int ny = cy + bomb[i][d][1];
                if (isIn(nx, ny) && !nextChk[nx][ny]) {
                    newCount++;
                    nextChk[nx][ny] = true;
                }
            }

            simulation(depth + 1, newCount, nextChk);
        }
    }

    public static boolean[][] copyChk(boolean[][] src) {
        boolean[][] dest = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, src[i].length);
        }
        return dest;
    }

    public static boolean isIn(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n);
    }
}
