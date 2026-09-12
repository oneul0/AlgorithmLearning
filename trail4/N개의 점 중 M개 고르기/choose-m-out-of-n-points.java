import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] points;
    static int[] selected;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        selected = new int[m];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        choose(0, 0);

        System.out.println(answer);
    }

    // cnt : 지금까지 선택한 점 개수
    // start : 다음으로 선택할 점의 시작 인덱스
    static void choose(int cnt, int start) {
        if (cnt == m) {
            answer = Math.min(answer, getMaxDist());
            return;
        }

        for (int i = start; i < n; i++) {

            selected[cnt] = i;

            choose(cnt + 1, i + 1);
        }
    }

    static int getMaxDist() {

        int maxDistance = 0;

        for (int i = 0; i < m; i++) {

            for (int j = i + 1; j < m; j++) {

                int p1 = selected[i];
                int p2 = selected[j];

                int dx = points[p1][0] - points[p2][0];
                int dy = points[p1][1] - points[p2][1];

                int distance = dx * dx + dy * dy;

                maxDistance = Math.max(maxDistance, distance);
            }
        }

        return maxDistance;
    }
}