class Solution {
    class Pair {
        int stop;
        int busCount;

        Pair(int stop, int busCount) {
            this.stop = stop;
            this.busCount = busCount;
        }
    }

    // 정류장 번호 -> 해당 정류장을 지나는 버스 번호 목록
    Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.computeIfAbsent(stop, key -> new ArrayList<>()).add(bus);
            }
        }

        return bfs(source, target, routes);
    }

    private int bfs(int source, int target, int[][] routes) {
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[] visitedBuses = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();

        queue.offer(new Pair(source, 0));
        visitedStops.add(source);

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            // 현재 정류장을 지나는 버스
            List<Integer> buses = stopToBuses.getOrDefault(cur.stop,Collections.emptyList());

            for (int bus : buses) {
                // 이미 노선 전체를 확인한 버스라면
                if (visitedBuses[bus]) continue;

                visitedBuses[bus] = true;
                int nextBusCount = cur.busCount + 1;

                // 이 버스가 지나는 모든 정류장으로 이동 가능
                for (int nextStop : routes[bus]) {
                    if (nextStop == target) return nextBusCount;

                    if (visitedStops.add(nextStop)) {
                        queue.offer(new Pair(nextStop, nextBusCount));
                    }
                }
            }
        }

        return -1;
    }
}