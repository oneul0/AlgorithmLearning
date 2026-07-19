class Solution {

    class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    List<List<Pair>> gr = new ArrayList<>();
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            gr.get(from).add(new Pair(to, weight));
            gr.get(to).add(new Pair(from, weight));
        }

        int answer = -1;
        int minCount = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {
            int reachableCount = dijkstra(city, n, distanceThreshold);

            if (reachableCount <= minCount) {
                minCount = reachableCount;
                answer = city;
            }
        }

        return answer;
    }

    private int dijkstra(int start, int n, int distanceThreshold) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        distance[start] = 0;
        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int currentNode = current.node;
            int currentCost = current.cost;

            // 이미 더 짧은 경로가 처리된 경우
            if (currentCost > distance[currentNode]) continue;

            // 제한 거리를 초과하면 탐색할 필요가 없음
            if (currentCost > distanceThreshold) continue;

            for (Pair next : gr.get(currentNode)) {
                int nextNode = next.node;
                int nextCost = currentCost + next.cost;

                if (nextCost > distanceThreshold) {
                    continue;
                }

                if (nextCost < distance[nextNode]) {
                    distance[nextNode] = nextCost;
                    pq.offer(new Pair(nextNode, nextCost));
                }
            }
        }

        int count = 0;

        for (int city = 0; city < n; city++) {
            if (city != start && distance[city] <= distanceThreshold) {
                count++;
            }
        }

        return count;
    }
}