import java.util.*;
import java.io.*;

class Solution {

    static class Coord {
        int x, y, z;

        Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    // 두 점 사이의 벡터
    static long[] vector(Coord a, Coord b) {
        return new long[] {
            (long)b.x - a.x,
            (long)b.y - a.y,
            (long)b.z - a.z
        };
    }

    // 외적
    static long[] cross(long[] a, long[] b) {
        return new long[] {
            a[1] * b[2] - a[2] * b[1],
            a[2] * b[0] - a[0] * b[2],
            a[0] * b[1] - a[1] * b[0]
        };
    }

    // 내적
    static long dot(long[] a, long[] b) {
        return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
    }

    static int check(Coord[] coords) {
        int n = coords.length;

        if (n <= 3) return 1;

        Coord A = coords[0];

        // A와 다른 점 B 찾기
        int b = 1;
        while (b < n && coords[b].x == A.x && coords[b].y == A.y && coords[b].z == A.z) {
            b++;
        }

        if (b == n) return 1;

        long[] AB = vector(A, coords[b]);
        long[] normal = null;

        // A, B와 일직선상에 있지 않은 C 찾기
        for (int i = b + 1; i < n; i++) {
            long[] AC = vector(A, coords[i]);

            long[] temp = cross(AB, AC);

            if (temp[0] != 0 || temp[1] != 0 || temp[2] != 0) {
                normal = temp;
                break;
            }
        }

        // 모든 점이 일직선 위에 있는 경우
        if (normal == null) return 1;

        // 나머지 점들이 평면 위에 있는지 확인
        for (int i = 0; i < n; i++) {
            long[] AP = vector(A, coords[i]);

            if (dot(normal, AP) != 0) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            Coord[] coords = new Coord[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                coords[i] = new Coord(x, y, z);
            }

            String answer = check(coords) == 1 ? "TAK" : "NIE";

            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
