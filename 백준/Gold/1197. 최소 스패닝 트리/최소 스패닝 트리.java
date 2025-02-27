import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V, E;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];

        for(int i = 1; i<=V; i++){
            parents[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int con = 0, ans = 0;

        while(con < V-1){
            Node cur = pq.poll();
            if(find(cur.from) != find(cur.to)){
                union(cur.from, cur.to);
                ans += cur.cost;
                con++;
            }
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static void union(int from, int to){
        from = find(from);
        to = find(to);

        if(from != to){
            parents[to] = from;
        }
    }

    static int find(int a){
        if(parents[a] == a){
            return a;
        }
        else return parents[a] = find(parents[a]);
    }


}

class Node implements Comparable<Node>{
    int from, to, cost;

    Node(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost,o.cost);
    }
}