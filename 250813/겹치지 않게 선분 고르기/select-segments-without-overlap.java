import java.util.*;

public class Main {
    static int answer = 0;
    static int[][] segments;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        Arrays.sort(segments, (a, b) -> Integer.compare(a[0], b[0]));
        //시작 x값, 선분 수
        findMaxLine(1, 0, 0);
        System.out.print(answer);
    }

    public static void findMaxLine(int cx, int count, int idx){
        if(idx >= segments.length){
            answer = Math.max(answer, count);
            return;
        }

        if(cx <= segments[idx][0]){
            findMaxLine(segments[idx][1], count+1, idx+1);
        }

        findMaxLine(cx, count, idx+1);
    }
}