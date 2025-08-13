import java.util.*;

public class Main {
    static int n, m, H = 0;
    static int[] guide;
    static boolean[][] ladder;
    static int answer = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        guide = new int[n + 1];

        ArrayList<int[]> connections = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            connections.add(new int[]{a, b});
            H = Math.max(H, b);
        }

        for (int i = 1; i <= n; i++) {
            guide[i] = simulateOriginal(i, connections);
        }

        ladder = new boolean[H + 1][n];

        backtracking(0, 1, 1);

        System.out.println(answer);
    }

    // 초기 가로줄 상태로 시뮬레이션
    static int simulateOriginal(int start, ArrayList<int[]> conn) {
        int cur = start;
        for (int y = 1; y <= H; y++) {
            for (int[] c : conn) {
                if (c[1] == y) {
                    if (c[0] == cur) cur++;
                    else if (c[0] + 1 == cur) cur--;
                }
            }
        }
        return cur;
    }

    // 현재 ladder 상태 기준으로 모든 사람이 guide와 일치하는지 검사
    static boolean checkAllArrived() {
        for (int i = 1; i <= n; i++) {
            int cur = i;
            for (int y = 1; y <= H; y++) {
                if (cur < n && ladder[y][cur]) cur++;
                else if (cur > 1 && ladder[y][cur - 1]) cur--;
            }
            if (cur != guide[i]) return false;
        }
        return true;
    }

    static void backtracking(int depth, int sy, int sx) {
        if (depth > H) return;
        if (checkAllArrived()) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int y = sy; y <= H; y++) {
            for (int x = (y == sy ? sx : 1); x < n; x++) {
                if (canPlace(y, x)) {
                    ladder[y][x] = true;
                    backtracking(depth + 1, y, x);
                    ladder[y][x] = false;
                }
            }
        }
    }

    // 좌우 겹치는 가로줄 체크
    static boolean canPlace(int y, int x) {
        if (ladder[y][x]) return false;
        if (x > 1 && ladder[y][x - 1]) return false;
        if (x < n - 1 && ladder[y][x + 1]) return false;
        return true;
    }
}
