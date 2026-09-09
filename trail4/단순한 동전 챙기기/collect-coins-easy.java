import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int dist(Point a, Point b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Point start = null;
        Point end = null;

        // coin[i] = i번 동전의 위치
        Point[] coin = new Point[10];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < N; c++) {
                char ch = line.charAt(c);

                if (ch == 'S') {
                    start = new Point(r, c);
                } else if (ch == 'E') {
                    end = new Point(r, c);
                } else if ('1' <= ch && ch <= '9') {
                    int num = ch - '0';
                    coin[num] = new Point(r, c);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        // 증가하는 순서의 동전 3개 선택
        for (int i = 1; i <= 9; i++) {
            if (coin[i] == null) continue;

            for (int j = i + 1; j <= 9; j++) {
                if (coin[j] == null) continue;

                for (int k = j + 1; k <= 9; k++) {
                    if (coin[k] == null) continue;

                    int distance =
                            dist(start, coin[i])
                            + dist(coin[i], coin[j])
                            + dist(coin[j], coin[k])
                            + dist(coin[k], end);

                    answer = Math.min(answer, distance);
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}