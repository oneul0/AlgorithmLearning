import java.util.*;

class Solution {
    ArrayList<ArrayList<Pair>> gh = new ArrayList<>();
    int n;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;

        for (int i = 0; i <= n; i++) {
            gh.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            gh.get(fare[0]).add(new Pair(fare[1], fare[2]));
            gh.get(fare[1]).add(new Pair(fare[0], fare[2]));
        }

        // s,a,b에서 모든 노드까지의 최단 거리 계산
        int[] distFromS = dijkstra(s);
        int[] distFromA = dijkstra(a);
        int[] distFromB = dijkstra(b);

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            minDistance = Math.min(minDistance, distFromA[i] + distFromB[i] + distFromS[i]);
        }

        return minDistance;
    }

    public int[] dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Pair(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.cost > dist[cur.node]) continue;

            for (Pair nxt : gh.get(cur.node)) {
                int nxtCost = nxt.cost + cur.cost;
                if (nxtCost < dist[nxt.node]) {
                    dist[nxt.node] = nxtCost;
                    pq.offer(new Pair(nxt.node, nxtCost));
                }
            }
        }

        return dist;
    }
}

class Pair implements Comparable<Pair> {
    int node, cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.cost, o.cost);
    }
}
