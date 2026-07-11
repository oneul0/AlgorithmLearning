class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(0, graph, path, answer);
        return answer;
    }

    private void dfs(int cur, int[][] graph, List<Integer> path, List<List<Integer>> answer){
        if(cur == graph.length-1){
            answer.add(new ArrayList<>(path));
            return;
        }

        for(int next : graph[cur]){
            path.add(next);
            dfs(next, graph, path, answer);
            path.remove(path.size()-1);
        }
    }
}