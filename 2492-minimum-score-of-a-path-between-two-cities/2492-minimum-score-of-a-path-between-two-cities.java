class Solution {
    class Pair {
        int to;
        int cost;

        Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    List<List<Pair>> gr;
    boolean[] visited;
    int minCost = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        gr = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int cost = road[2];

            gr.get(from).add(new Pair(to, cost));
            gr.get(to).add(new Pair(from, cost));
        }

        dfs(1);

        return minCost;
    }

    private void dfs(int cur) {
        visited[cur] = true;

        for (Pair next : gr.get(cur)) {
            minCost = Math.min(minCost, next.cost);

            if (!visited[next.to]) {
                dfs(next.to);
            }
        }
    }
}