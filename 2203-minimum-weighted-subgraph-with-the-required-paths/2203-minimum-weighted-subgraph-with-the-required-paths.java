class Solution {

    class Pair implements Comparable<Pair> {
        int to;
        long cost;

        Pair(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    private static final long INF = Long.MAX_VALUE / 4;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<Pair>> graph = new ArrayList<>();
        List<List<Pair>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph.get(from).add(new Pair(to, weight));
            reverseGraph.get(to).add(new Pair(from, weight));
        }

        long[] dist1 = dijkstra(n, graph, src1);
        long[] dist2 = dijkstra(n, graph, src2);
        long[] distToDest = dijkstra(n, reverseGraph, dest);

        long answer = INF;

        for (int i = 0; i < n; i++) {
            if (dist1[i] == INF || dist2[i] == INF || distToDest[i] == INF) continue;

            answer = Math.min(answer, dist1[i] + dist2[i] + distToDest[i]);
        }

        return answer == INF ? -1 : answer;
    }

    private long[] dijkstra(int n, List<List<Pair>> graph, int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Pair next : graph.get(cur.to)) {
                long newCost = cur.cost + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Pair(next.to, newCost));
                }
            }
        }

        return dist;
    }
}