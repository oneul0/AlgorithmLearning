class Solution {
    class Pair {
        String name;
        int count;

        Pair(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;

        List<Integer> people = bfs(friends, id, n, level);

        Map<String, Integer> countMap = new HashMap<>();

        for (int person : people) {
            for (String video : watchedVideos.get(person)) {
                countMap.put(video, countMap.getOrDefault(video, 0)+1);
            }
        }

        List<Pair> videoCounts = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            videoCounts.add(new Pair(entry.getKey(), entry.getValue()));
        }

        videoCounts.sort((a, b) -> {
            if (a.count != b.count) {
                return Integer.compare(a.count, b.count);
            }

            return a.name.compareTo(b.name);
        });

        List<String> answer = new ArrayList<>();

        for (Pair pair : videoCounts) {
            answer.add(pair.name);
        }

        return answer;
    }

    private List<Integer> bfs(int[][] friends, int start, int n, int level) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        List<Integer> people = new ArrayList<>();

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int distance = current[1];

            if (distance == level) {
                people.add(person);
                continue;
            }

            for (int next : friends[person]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, distance+1});
                }
            }
        }

        return people;
    }
}