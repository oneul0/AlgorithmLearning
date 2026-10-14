import java.io.*;
import java.util.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static int N, W, H, answer;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static void dfs(int depth, int[][] board, int remaining) {
        if (remaining == 0) {
            answer = 0;
            return;
        }
        if (depth == N) {
            answer = Math.min(answer, remaining);
            return;
        }

        for (int col = 0; col < W; col++) {
            int row = 0;
            while (row < H && board[row][col] == 0) row++;
            if (row == H) continue; // 빈 열은 쏘아도 변화가 없다.

            int[][] next = copyBoard(board);
            int removed = explode(next, row, col);
            applyGravity(next);
            dfs(depth + 1, next, remaining - removed);
            if (answer == 0) return;
        }
    }

    static int[][] copyBoard(int[][] board) {
        int[][] copied = new int[H][W];
        for (int row = 0; row < H; row++) {
            System.arraycopy(board[row], 0, copied[row], 0, W);
        }
        return copied;
    }

    static int explode(int[][] board, int startRow, int startCol) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol, board[startRow][startCol]});
        board[startRow][startCol] = 0;
        int removed = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], power = current[2];

            for (int dir = 0; dir < 4; dir++) {
                for (int step = 1; step < power; step++) {
                    int nr = row + dr[dir] * step;
                    int nc = col + dc[dir] * step;
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) break;
                    if (board[nr][nc] == 0) continue;

                    queue.offer(new int[]{nr, nc, board[nr][nc]});
                    board[nr][nc] = 0; // 큐에 넣는 순간 제거해 중복 폭발 방지.
                    removed++;
                }
            }
        }
        return removed;
    }

    static void applyGravity(int[][] board) {
        for (int col = 0; col < W; col++) {
            int write = H - 1;
            for (int row = H - 1; row >= 0; row--) {
                if (board[row][col] != 0) {
                    board[write][col] = board[row][col];
                    if (write != row) board[row][col] = 0;
                    write--;
                }
            }
            while (write >= 0) board[write--][col] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        StringBuilder result = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = nextInt();
            W = nextInt();
            H = nextInt();
            int[][] board = new int[H][W];
            int remaining = 0;

            for (int row = 0; row < H; row++) {
                for (int col = 0; col < W; col++) {
                    board[row][col] = nextInt();
                    if (board[row][col] != 0) remaining++;
                }
            }

            answer = remaining;
            dfs(0, board, remaining);
            result.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(result);
    }
}
