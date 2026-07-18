class Solution {
    class Pair implements Comparable<Pair> {
        int to;
        int time;

        Pair(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> gr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] time : times) {
            gr.get(time[0]).add(new Pair(time[1], time[2]));
        }

        return dijkstra(gr, n, k);
    }

    private int dijkstra(List<List<Pair>> gr, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.time > dist[cur.to]) continue;

            for (Pair next : gr.get(cur.to)) {
                int newTime = cur.time + next.time;

                if (newTime < dist[next.to]) {
                    dist[next.to] = newTime;
                    pq.offer(new Pair(next.to, newTime));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}