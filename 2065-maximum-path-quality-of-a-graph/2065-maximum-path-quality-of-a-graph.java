class Solution {
    int answer;
    int[] values;
    int[] visitCount;
    List<int[]>[] gr;
    int maxTime;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.maxTime = maxTime;

        int n = values.length;
        gr = new ArrayList[n];
        visitCount = new int[n];

        for (int i = 0; i < n; i++) {
            gr[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

            gr[u].add(new int[]{v, time});
            gr[v].add(new int[]{u, time});
        }

        visitCount[0] = 1;
        dfs(0, 0, values[0]);

        return answer;
    }

    private void dfs(int node, int time, int quality) {
        if (node == 0) {
            answer = Math.max(answer, quality);
        }

        for (int[] edge : gr[node]) {
            int next = edge[0];
            int cost = edge[1];

            if (time + cost > maxTime) {
                continue;
            }

            boolean firstVisit = visitCount[next] == 0;

            visitCount[next]++;

            dfs(next, time + cost, quality + (firstVisit ? values[next] : 0));

            visitCount[next]--;
        }
    }
}