import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dp = new int[501];
    static ArrayList<Line> lines = new ArrayList<>();
    public static void main(String[] args) throws  Exception{
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            lines.add(new Line(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        // 왼쪽 전봇대 기준으로 정렬하고
        Collections.sort(lines);
        int connLine = 0; //연결된 전선 중 최대
        // 오른쪽 전봇대에서 가장 긴 증가하는 부분 수열을 구하는 경우가
        // 문제의 해답과 같다.
        for(int i = 0; i<N; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if(lines.get(i).b > lines.get(j).b){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            connLine = Math.max(dp[i], connLine);
        }
        bw.write(N-connLine + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Line implements Comparable<Line>{
    int a, b;
    public Line(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Line o) {
        return this.a - o.a;
    }
}
