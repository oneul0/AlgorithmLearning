
import java.util.*;
class Solution {
    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    int N, M;
    App[] app;

    static class App {
        int r, c;
        int l = 0;
    }

    public int[][] solution(int[][] board, int[][] commands) {
        N = board.length;
        M = board[0].length;

        app = new App[101];
        for (int i = 0; i < 101; i++) {
            app[i] = new App();
        }

        // 각 객체의 위치와 크기 초기화
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int id = board[r][c];

                if (app[id].l == 0) {
                    app[id].r = r;
                    app[id].c = c;

                    for (int i = c; i < M && board[r][i] == id; i++) {
                        app[id].l++;
                    }
                }
            }
        }

        // 명령 실행
        for (int[] command : commands) {
            push(board, command[0], command[1]-1);
        }

        return board;
    }

    // 좌표 순환 처리
    private int wrap(int x, int size) {
        return Math.floorMod(x, size);
    }

    // 객체 이동 및 연쇄 밀기
    private void push(int[][] board, int id, int dir) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] inq = new boolean[101];

        q.offer(id);
        inq[id] = true;

        while (!q.isEmpty()) {
            int i = q.poll();
            inq[i] = false;

            int br = app[i].r + (dir == 3 ? app[i].l - 1 : 0);
            int bc = app[i].c + (dir == 2 ? app[i].l - 1 : 0);

            // 기존 위치 제거
            for (int j = 0; j < app[i].l; j++) {
                int r = br + j * (~dir & 1);
                int c = bc + j * (dir & 1);

                r = wrap(r, N);
                c = wrap(c, M);

                if (board[r][c] == i) {
                    board[r][c] = 0;
                }
            }

            // 이동할 위치 계산
            if ((dir & 1) != 0) {
                br += app[i].l * (dir == 1 ? 1 : -1);
            } else {
                bc += app[i].l * (dir == 0 ? 1 : -1);
            }

            // 이동할 위치의 다른 객체 확인
            for (int j = 0; j < app[i].l; j++) {
                int r = br + j * (~dir & 1);
                int c = bc + j * (dir & 1);

                r = wrap(r, N);
                c = wrap(c, M);

                int jd = board[r][c];

                if (jd != 0 && !inq[jd]) {
                    q.offer(jd);
                    inq[jd] = true;
                }

                board[r][c] = i;
            }

            // 객체 위치 갱신
            app[i].r += DR[dir];
            app[i].c += DC[dir];

            app[i].r = wrap(app[i].r, N);
            app[i].c = wrap(app[i].c, M);

            // 경계를 넘어가는 객체 추가 처리
            if (app[i].r + app[i].l > N ||
                app[i].c + app[i].l > M) {

                inq[i] = true;
                q.offer(i);
            }
        }
    }
}
