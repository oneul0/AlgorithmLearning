import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static ArrayList<ArrayList<Node>> mootube;

    public static void main(String[] args) throws IOException {
        String[] nq = br.readLine().split(" ");
        n = Integer.parseInt(nq[0]);
        m = Integer.parseInt(nq[1]);

        mootube = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            mootube.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int u = Integer.parseInt(s[2]);
            mootube.get(p).add(new Node(q, u));
            mootube.get(q).add(new Node(p, u));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);

            boolean[] chk = new boolean[n+1];
            chk[to] = true;
            Queue<Integer> q = new LinkedList<>();
            q.offer(to);

            int cnt = 0;
            while(!q.isEmpty()) {
                int cur = q.poll();

                for(Node node : mootube.get(cur)) {
                    if(!chk[node.to] && node.usado >= from){
                        chk[node.to] = true;
                        q.offer(node.to);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}

class Node {
    int to, usado;

    public Node(int to, int usado) {
        this.to = to;
        this.usado = usado;
    }
}