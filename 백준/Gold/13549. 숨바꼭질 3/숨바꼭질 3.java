import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        PriorityQueue<Cur> pq = new PriorityQueue<>();
        int[] chk = new int[100001];
        Arrays.fill(chk, 100000);
        chk[N] = 0;

        pq.offer(new Cur(N, 0,K-N));
        while(!pq.isEmpty()){
            Cur cur = pq.poll();

            if(chk[cur.x] < cur.depth) continue;

            int[] nPos = cur.x > K ? new int[]{cur.x-1} : new int[]{cur.x * 2, cur.x - 1, cur.x + 1};

            for (int nx : nPos) {
                if (nx >= 0 && nx <= 100000 && chk[nx] > cur.depth + (nx == cur.x * 2 ? 0 : 1)) {

                    pq.offer(new Cur(nx, cur.depth + (nx == cur.x * 2 ? 0 : 1), K - nx));
                    chk[nx] = cur.depth + (nx == cur.x * 2 ? 0 : 1);
                }
            }
        }
        bw.write(Integer.toString(chk[K]));
        bw.flush();
        br.close();
        bw.close();

    }
}

class Cur implements Comparable<Cur> {
    int x, depth, diff;
    Cur(int x, int depth, int diff) {
        this.x = x;
        this.depth = depth;
        this.diff = diff;
    }

    @Override
    public int compareTo(Cur o) {
        if(depth == o.depth) return diff - o.diff;
        return depth - o.depth;
    }
}