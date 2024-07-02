import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 입력 처리
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int maxWeight = Integer.parseInt(input[1]);

        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] item = br.readLine().split(" ");
            int weight = Integer.parseInt(item[0]);
            int value = Integer.parseInt(item[1]);
            list.add(new Pair<>(weight, value));
        }

        // dp 배열 초기화
        int[][] dp = new int[n + 1][maxWeight + 1];

        // DP 알고리즘
        for (int i = 1; i <= n; i++) {
            int k = list.get(i - 1).getFirst();
            int v = list.get(i - 1).getSecond();
            for (int j = 0; j <= maxWeight; j++) {
                if (k > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], v + dp[i - 1][j - k]);
                }
            }
        }

        // 결과 출력
        bw.write(String.valueOf(dp[n][maxWeight]));
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}

class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
