import java.util.*;

public class Main {
    static int answer = 0, limit = 0;
    static int[][] segments;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
            limit = Math.max(limit, segments[i][1]);
        }
        //시작 x값, 선분 수
        findMaxLine(1, 0);
        System.out.print(answer);
    }

    public static void findMaxLine(int depth, int count){
        if(depth >= limit){
            answer = Math.max(answer, count);
            return;
        }

        for(int[] seg : segments){
            if(seg[0]>=depth){
                findMaxLine(seg[1]+1, count+1);
            }
        }
    }
}