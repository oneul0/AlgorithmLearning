class Graph {
    static final long INF = Long.MAX_VALUE / 4;

    final int n;
    final long[][] dist;

    public Graph(int n, int[][] edges) {
        this.n = n;
        this.dist = new long[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 초기 간선 등록
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            dist[from][to] = Math.min(dist[from][to], cost);
        }

        // 모든 정점 쌍의 최단 거리 계산
        for (int k = 0; k < n; k++) {
            for (int from = 0; from < n; from++) {
                if (dist[from][k] == INF) {
                    continue;
                }

                for (int to = 0; to < n; to++) {
                    if (dist[k][to] == INF) {
                        continue;
                    }

                    dist[from][to] = Math.min(
                        dist[from][to],
                        dist[from][k] + dist[k][to]
                    );
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int newFrom = edge[0];
        int newTo = edge[1];
        long newCost = edge[2];

        //기존 최단 거리보다 비싼 간선이면 갱신할 필요 없음
        if (dist[newFrom][newTo] <= newCost) {
            return;
        }

        //새 간선을 포함하는 모든 경로를 확인
        for (int from = 0; from < n; from++) {
            if (dist[from][newFrom] == INF) {
                continue;
            }

            for (int to = 0; to < n; to++) {
                if (dist[newTo][to] == INF) {
                    continue;
                }

                long newDistance =
                    dist[from][newFrom] + newCost + dist[newTo][to];

                dist[from][to] = Math.min(dist[from][to], newDistance);
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        if (dist[node1][node2] == INF) {
            return -1;
        }

        return (int) dist[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */